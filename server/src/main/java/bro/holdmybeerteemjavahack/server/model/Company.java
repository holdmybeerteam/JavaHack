package bro.holdmybeerteemjavahack.server.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "COMPANY", schema = "JAVA_HACK")
public class Company extends Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private BigInteger id  = null;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(schema = "java_hack", name = "task")
	@JoinColumn(name = "task_id")
	private List<Task> tasks;
}
