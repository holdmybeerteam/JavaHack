package bro.holdmybeerteem.javahack.server.model

import java.math.BigInteger
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

abstract class User (


    var companyName: String? = null,

    var accountNumber: String? = null
)