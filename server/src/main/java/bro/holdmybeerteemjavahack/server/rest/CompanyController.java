package bro.holdmybeerteemjavahack.server.rest;

import bro.holdmybeerteemjavahack.server.model.Company;
import bro.holdmybeerteemjavahack.server.services.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/rest-api/companies")
@CrossOrigin
public class CompanyController
{
	private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

	private final CompanyService companyService;

	public CompanyController(CompanyService companyService)
	{
		this.companyService = companyService;
	}

	@PostMapping
	public ResponseEntity createCompany(@RequestBody Company company) throws JsonProcessingException
	{
		log.info(new ObjectMapper().writeValueAsString(company));
		BigInteger id = companyService.save(company);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Company>> getCompanies()
	{
		return new ResponseEntity<>(companyService.getCompanies(), HttpStatus.OK);
	}


}
