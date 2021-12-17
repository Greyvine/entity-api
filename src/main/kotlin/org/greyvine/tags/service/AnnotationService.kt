package org.greyvine.tags.service

import org.greyvine.tags.dto.AnnotatedDocumentDTO

interface AnnotationService {

    fun annotate(text: String): AnnotatedDocumentDTO

}