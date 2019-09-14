package bro.holdmybeerteemjavahack.server.rest;

import bro.holdmybeerteemjavahack.server.model.User;
import bro.holdmybeerteemjavahack.server.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController
{

	private final UserService userService;

	public SignUpController(UserService userService)
	{
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<String> signUp(Authentication authentication, @RequestBody User user) {
		String token = userService.signUp(user);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
}
