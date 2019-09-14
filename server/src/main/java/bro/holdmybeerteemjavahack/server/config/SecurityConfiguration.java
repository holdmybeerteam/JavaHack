package bro.holdmybeerteemjavahack.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

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
	private final DataSource dataSource;

	public SecurityConfiguration(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{

//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.passwordEncoder(new BCryptPasswordEncoder())
//				.usersByUsernameQuery("select username, password from java_hack.user where username=?")
//				.authoritiesByUsernameQuery("select u.username, a.role from java_hack.user u, java_hack.authority a where u.username=? and u.user_id = a.user_id");
		auth.jdbcAuthentication()
				.withDefaultSchema()
				.dataSource(dataSource)
				.withUser("Company").password(passwordEncoder().encode("pass")).roles("COMPANY")
				.and()
				.withUser("Worker").password(passwordEncoder().encode("pass")).roles("WORKER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/console/**", "/login/**", "/signup/**").permitAll()
				.antMatchers("/rest-api/**").hasAnyAuthority("ROLE_COMPANY", "ROLE_WORKER")
				.and()
				.httpBasic();

		http.csrf()
				.ignoringAntMatchers("/console/**", "/signup/**", "/login/**", "/rest-api/**");
		http.headers()
				.frameOptions()
				.sameOrigin();

	}
@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
}
}

