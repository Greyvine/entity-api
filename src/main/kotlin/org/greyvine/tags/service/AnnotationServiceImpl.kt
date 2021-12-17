package org.greyvine.tags.service

import org.greyvine.tags.dto.AnnotatedDocumentDTO
import org.greyvine.tags.dto.AnnotationValueDTO
import org.greyvine.tags.parser.AnnotatedDocument
import org.greyvine.tags.parser.AnnotatedValue
import org.springframework.stereotype.Service

@Service
class AnnotationServiceImpl : AnnotationService {

    override fun annotate(text: String) = AnnotatedDocument(text).toDTO()

//    override fun annotate(text: String) = CoreDocument(text)
//        .also { pipeline.annotate(it) }
//        .let { AnnotationDTO(
//            text,
//            values = emptyList(),
//        ) }

    companion object {

//        private val pipeline = Properties()
//            .apply {
//                setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote,entitymentions")
//                setProperty("coref.algorithm", "neural")
//            }
//            .let { StanfordCoreNLP(it) }

        private fun AnnotatedDocument.toDTO() =
            AnnotatedDocumentDTO(
                this.text,
                this.annotations.map { it.toDTO() }
            )

        private fun AnnotatedValue.toDTO() =
            AnnotationValueDTO(
                this.label,
                this.value
            )

    }

}