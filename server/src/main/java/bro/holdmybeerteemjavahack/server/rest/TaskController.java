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
@RequestMapping("/rest-api/tasks")
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
		return new ResponseEntity<>(taskService.createTask(task), HttpStatus.OK);
	}


}
