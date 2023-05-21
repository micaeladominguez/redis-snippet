package org.austral.ingsis.demo.route

import org.austral.ingsis.demo.producer.ProductCreatedProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StreamTestRoute @Autowired constructor(private val producer: ProductCreatedProducer) {

    @PostMapping("v1/stream/{name}")
    suspend fun post(@PathVariable name: String) {
        producer.publishEvent(name)
    }
}