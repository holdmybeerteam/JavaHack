package bro.holdmybeerteem.javahack.server.model

import java.math.BigInteger
import javax.persistence.*

@Entity
@Table(schema = "java-hack", name = "worker")
data class Worker(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: BigInteger? = null
) : User()