package bro.holdmybeerteemjavahack.server.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "USER", schema = "java_hack")
public class User implements UserDetails
{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private BigInteger id;

	private String username;
	private String password;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isEnabled;
	private boolean isCredentialNonExpired;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(schema = "java_hack", name = "authority")
	@JoinColumn(name = "authority_id")
	private List<Authority> authorities;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername()
	{
		return username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return isCredentialNonExpired;
	}

	@Override
	public boolean isEnabled()
	{
		return isEnabled;
	}
}
