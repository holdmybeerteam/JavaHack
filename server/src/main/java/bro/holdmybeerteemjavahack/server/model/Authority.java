package bro.holdmybeerteemjavahack.server.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "AUTHORITY", schema = "java_hack")
public class Authority implements GrantedAuthority
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private BigInteger id  = null;

	@Column(length = 30, nullable = false)
	private String role;

	@Override
	public String getAuthority()
	{
		return role;
	}

	public Authority(String role)
	{
		this.role = role;
	}
}
