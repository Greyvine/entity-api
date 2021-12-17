package org.greyvine.tags.parser

object PhraseDictionary {

    private val ageRegex = """(\d*?)\s?years\s?old""".toRegex()
    private val nameRegex = """named\s(\S*)""".toRegex()

    val phrases = mapOf(
        "age" to ageRegex,
        "name" to nameRegex,
    )

}