package bro.holdmybeerteemjavahack.server.rest;

import bro.holdmybeerteemjavahack.server.model.Payment;
import bro.holdmybeerteemjavahack.server.model.Task;
import bro.holdmybeerteemjavahack.server.services.CompanyService;
import bro.holdmybeerteemjavahack.server.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/rest-api/payment")
@CrossOrigin
public class PaymentController
{
	private final TaskService taskService;

	public PaymentController(TaskService taskService)
	{
		this.taskService = taskService;
	}

	/*@PutMapping("/request")
	public ResponseEntity requestPayment(@RequestParam("taskId") BigInteger taskId)
	{
		*//*send request into Bank for sending pay to the worker (by auth token) for the task *//*
		return new ResponseEntity(getStatus(taskId));
	}

	private HttpStatus getStatus(BigInteger taskId){
		//TODO(add NO_CONTENT message: "Клиент не подтвердил выполнение данной задачи")
		return taskService.getTask(taskId).isDone() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
	}*/

	@PostMapping("/hold")
	public ResponseEntity holdPayment(@RequestBody Payment payment) {
		/*send payment into Bank for hold*/
		return new ResponseEntity(HttpStatus.OK);
	}


}
