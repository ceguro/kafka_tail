package com.example.kafka_tail.controllers

import com.example.kafka_tail.services.kafka.TestKafkaProducer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
        private val testKafkaProducer: TestKafkaProducer
) {

    @PostMapping("kafka/test", produces = ["application/json"])
    fun sendKafka(@RequestBody message: String) =
            ResponseEntity(testKafkaProducer.sendMessage(message), HttpStatus.OK)

}