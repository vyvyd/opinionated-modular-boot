package com.demo.opinionatedmodularboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpinionatedModularBootApplication

fun main(args: Array<String>) {
    runApplication<OpinionatedModularBootApplication>(*args)
}
