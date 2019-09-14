package bro.holdmybeerteem.javahack.server.model

import java.math.BigInteger
import javax.persistence.*

@Entity
@Table(name = "company", schema = "java-hack")
data class Company(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: BigInteger? = null
) : User()