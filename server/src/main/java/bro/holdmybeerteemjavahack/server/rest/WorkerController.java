package bro.holdmybeerteemjavahack.server.rest;

import bro.holdmybeerteemjavahack.server.model.IndividualWorker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rest-api/workers")
public class WorkerController
{
	@PostMapping
	public ResponseEntity createWorker(@RequestBody IndividualWorker individualWorker){
		return new ResponseEntity(null, HttpStatus.OK);
	}


}