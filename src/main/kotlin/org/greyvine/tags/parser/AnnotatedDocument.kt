package org.greyvine.tags.parser

import mu.KotlinLogging

class AnnotatedDocument(
    val text: String
) {

    private val logger = KotlinLogging.logger {}

    val annotations get() = text.split(".")
        .flatMap { parseSentence(it) }

    private fun parseSentence(sentence: String) : List<AnnotatedValue> {
        logger.debug { "Parsing $sentence..." }
        return PhraseDictionary.phrases.mapNotNull { phrase ->
            phrase.value.find(sentence)
                ?.groupValues
                ?.last()
                ?.let { AnnotatedValue(phrase.key, it) }
        }
    }

}