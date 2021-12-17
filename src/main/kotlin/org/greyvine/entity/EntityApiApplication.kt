package org.greyvine.entity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = [
    "org.greyvine.tags",
    "org.greyvine.entity"
])
class EntityApiApplication

fun main(args: Array<String>) {
    runApplication<EntityApiApplication>(*args)
}