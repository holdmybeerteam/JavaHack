package bro.holdmybeerteem.javahack.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ServerApplicationKt

fun main(args: Array<String>) {
	runApplication<ServerApplicationKt>(*args)
}
