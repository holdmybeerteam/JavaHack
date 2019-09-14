package bro.holdmybeerteemjavahack.server.services;

import bro.holdmybeerteemjavahack.server.model.Authority;
import bro.holdmybeerteemjavahack.server.model.User;
import bro.holdmybeerteemjavahack.server.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}


	@Transactional
	@Override
	public String signUp(User user)
	{
		User userCopy =  new User(); // COMPANY or WORKER
		userCopy.setPassword(passwordEncoder.encode(user.getPassword()));
		userCopy.setUsername(user.getUsername());
		User savedUser = userRepository.save(userCopy);
		userCopy.setAuthorities(Collections.singletonList(new Authority("USER_ROLE")));
		return "TOKEN";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return null;
	}
}
