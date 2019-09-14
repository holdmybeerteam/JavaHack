package bro.holdmybeerteemjavahack.server.rest;

import bro.holdmybeerteemjavahack.server.model.Worker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rest-api/workers")
public class WorkerController
{
	@PostMapping
	public ResponseEntity createWorker(@RequestBody Worker worker){
		return new ResponseEntity(null, HttpStatus.OK);
	}


}