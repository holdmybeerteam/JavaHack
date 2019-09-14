package bro.holdmybeerteemjavahack.server.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "IndividualWorker", schema = "JAVA_HACK")
public class IndividualWorker extends Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private BigInteger id  = null;

	@Column(name = "account_number", length = 255, nullable = false)
	private String accountNumber = null;

	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName = null;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(schema = "java_hack", name = "task")
	@JoinColumn(name = "task_id")
	private List<Task> tasks;

}
