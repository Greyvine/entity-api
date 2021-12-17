package org.greyvine.entity.facade

import org.greyvine.entity.domain.Document
import org.greyvine.entity.domain.Collection
import org.greyvine.entity.domain.DocumentTag
import org.greyvine.entity.domain.Tag
import org.greyvine.entity.dto.CreateDocumentDTO
import org.greyvine.entity.dto.DocumentTagDTO
import org.greyvine.entity.dto.PatchEntityDTO

interface DocumentFacade {
    fun list(): List<Document>
    fun create(dto: CreateDocumentDTO): Document
    fun get(id: Int): Document?
    fun update(id: Int, dto: CreateDocumentDTO): Document
    fun delete(id: Int)
    fun listCollections(id: Int): List<Collection>
    fun updateCollections(id: Int, groups: List<PatchEntityDTO>)
    fun listTags(id: Int): List<DocumentTagDTO>
}