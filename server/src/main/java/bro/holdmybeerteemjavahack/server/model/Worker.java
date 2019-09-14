package bro.holdmybeerteemjavahack.server.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "Worker", schema = "JAVA_HACK")
public class Worker extends User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private BigInteger id  = null;

	@Column(name = "account_number", length = 255, nullable = false)
	private String accountNumber = null;

	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName = null;

}
