import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.jago.atm.service")
@EnableAutoConfiguration
class ATMApplication

fun main(args: Array<String>) {
    runApplication<ATMApplication>(*args)
}
