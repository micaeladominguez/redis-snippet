package org.austral.ingsis.demo.route

import org.austral.ingsis.demo.producer.ProductCreatedProducer
import org.austral.ingsis.demo.rule.LintedRules.Companion.getLintedRules
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StreamTestRoute @Autowired constructor(private val producer: ProductCreatedProducer) {

    @PostMapping("/linting")
    suspend fun post( @RequestBody getDTO: GetDTO) {
        val lintedRules = getLintedRules(getDTO.rules)
        producer.publishEvent(getDTO.snippet, lintedRules)
    }
}