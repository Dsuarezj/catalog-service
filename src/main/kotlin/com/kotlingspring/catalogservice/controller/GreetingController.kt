package com.kotlingspring.catalogservice.controller

import com.kotlingspring.catalogservice.service.GreetingService
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingController() {

    @Autowired
    val greetingService: GreetingService = GreetingService()

    companion object: KLogging()

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String {
        logger.info("Name is $name")
        return greetingService.retrieveGreeting(name)
    }
}