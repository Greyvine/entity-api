package org.greyvine.entity.service

import org.greyvine.entity.domain.DocumentTag
import org.greyvine.entity.domain.Tag
import org.greyvine.entity.dto.DocumentTagDTO

interface DocumentTagService {
    fun create(documentTag: DocumentTag): DocumentTag
    fun listByDocumentId(id: Int): List<DocumentTagDTO>
}