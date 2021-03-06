package bro.holdmybeerteemjavahack.server.rest;

import bro.holdmybeerteemjavahack.server.model.Task;
import bro.holdmybeerteemjavahack.server.services.CompanyService;
import bro.holdmybeerteemjavahack.server.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/rest-api/task")
@CrossOrigin
public class TaskController
{

	private final CompanyService companyService;

	private final TaskService taskService;

	public TaskController(CompanyService companyService, TaskService taskService)
	{
		this.companyService = companyService;
		this.taskService = taskService;
	}

	@GetMapping
	public ResponseEntity<List<Task>> getTasks(@RequestParam("companyId") BigInteger companyId)
	{
		return new ResponseEntity<>(companyService.getCompany(companyId).getTasks(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BigInteger> createTask(@RequestBody Task task) {
		return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.OK);
	}

	@PostMapping("/approve")
	public ResponseEntity approve(@RequestParam("taskId") BigInteger taskId) {
		Task updatedTask = taskService.getTask(taskId);
		updatedTask.setIsDone(true);
		taskService.saveTask(updatedTask);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/assign")
	public ResponseEntity setWorker(@RequestParam("taskId") BigInteger taskId) {
		Task updatedTask = taskService.getTask(taskId);
		BigInteger workerId = new BigInteger(""); //TODO(get workerId by auth token)
		updatedTask.setWorkerId(workerId);
		taskService.saveTask(updatedTask);
		return new ResponseEntity(HttpStatus.OK);
	}

}
