package com.example.kafka_tail.services.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.kafka.support.KafkaHeaders.RECEIVED_MESSAGE_KEY
import org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION_ID
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class TestKafkaConsumer {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(TestKafkaConsumer::class.java)
    }

    @KafkaListener(
            topics = ["\${kafka.topic.name1}"],
            groupId = "\${spring.kafka.consumer.group-id}")
    fun listenKafkaWithPayloadAndHeaders(
            @Payload message: String,
            @Header(RECEIVED_MESSAGE_KEY) key: ConsumerRecord<String, String>,
            @Header(RECEIVED_PARTITION_ID) partition: Int
    ) = run {
        logger.info("Received Message: $message from partition: $partition with key $key")
    }
}