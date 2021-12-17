package org.greyvine.tags.service

import mu.KotlinLogging
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    classes = [
        AnnotationServiceImpl::class
    ]
)
internal class AnnotationServiceImplTest {



    @Autowired
    lateinit var annotationServiceImpl: AnnotationServiceImpl

    val text = "This is the first admission for this 56 years old woman. One week prior to admission she noticed the abrupt onset (over a few seconds to a minute) of chest pain onset which she describes as dull and aching in character. The character pain began in the left para-sternal area and radiated up to location her neck. The first episode of pain one week ago occurred radiation when she was working in her garden in the middle of the circumstances; exacerbating factors day. She states she had been working for approximately 45 minutes and began to feel tired before the onset of the pain. Her discomfort was accompanied by shortness of breath, but associated symptoms no sweating, nausea, or vomiting. The pain lasted approximately 5 to 10 minutes and resolved when she went duration inside and rested in a cool area."

    @Test
    fun annotate() {
        val annotation = annotationServiceImpl.annotate(text)

        println(annotation)
    }
}