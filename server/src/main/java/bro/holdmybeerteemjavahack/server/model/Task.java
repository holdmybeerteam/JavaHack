package bro.holdmybeerteemjavahack.server.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;


@Data
@Entity
@Table(name = "TASK", schema = "JAVA_HACK")
public class Task
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private BigInteger id  = null;

	@Column(name = "description")
	private String description;


}
