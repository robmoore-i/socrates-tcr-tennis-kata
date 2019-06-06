package socratesuk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TarApplication

fun main(args: Array<String>) {
	runApplication<TarApplication>(*args)
}
