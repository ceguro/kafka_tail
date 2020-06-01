package com.example.kafka_tail

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaTailApplication

fun main(args: Array<String>) {
	runApplication<KafkaTailApplication>(*args)
}
