package bro.holdmybeerteemjavahack.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@ConfigurationProperties(prefix = "security")
@Configuration("securityConfig")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String user;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/rest-api/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf().disable();
//				.and()
//////				.formLogin()
//////				.loginPage("/login")
////				.permitAll()
//				.and()
//				.logout()
//				.permitAll();
	}

	@Bean
	@DependsOn(value = "securityConfig")
	@Override
	public UserDetailsService userDetailsService() {

		// TODO change encoder, separate credentials in properties file, encode password
		return new InMemoryUserDetailsManager(User.withDefaultPasswordEncoder()
				.username(this.user)
				.password(this.password)
				.roles("USER")
				.build());
	}
}

