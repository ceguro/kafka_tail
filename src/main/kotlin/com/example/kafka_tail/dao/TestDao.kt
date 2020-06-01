package com.example.kafka_tail.dao

import org.springframework.stereotype.Service

@Service
interface TestDao {
    fun save(message: String)
}