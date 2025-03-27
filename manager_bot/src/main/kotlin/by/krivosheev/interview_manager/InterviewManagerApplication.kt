package by.krivosheev.interview_manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class InterviewManagerApplication

fun main(args: Array<String>) {
    runApplication<InterviewManagerApplication>(*args)
}
