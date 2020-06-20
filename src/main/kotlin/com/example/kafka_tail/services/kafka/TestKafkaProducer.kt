package com.example.kafka_tail.services.kafka

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.lang.Nullable
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class TestKafkaProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    @Value(value = "\${kafka.topic.name1}")
    private val topicName: String = ""

    fun sendMessage(message: String) {
        val future: ListenableFuture<SendResult<String, String>> = kafkaTemplate.send(topicName, message)

        future.addCallback(object : ListenableFutureCallback<SendResult<String, String>> {
            override fun onSuccess(@Nullable result: SendResult<String, String>?) {
                if (result != null) {
                    println("Sent message=[ $message ] with offset=[ " + result.recordMetadata.offset() + " ] and partition=[" + result.recordMetadata.partition() + " ]")
                }
            }

            override fun onFailure(ex: Throwable) {
                println("Unable to send message=[ $message ] due to : $ex.message")
            }
        })
    }

}