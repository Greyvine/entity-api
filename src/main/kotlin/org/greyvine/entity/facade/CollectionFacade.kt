package org.greyvine.entity.facade

import org.greyvine.entity.domain.Document
import org.greyvine.entity.domain.Collection
import org.greyvine.entity.dto.CreateCollectionDTO
import org.greyvine.entity.dto.PatchEntityDTO

interface CollectionFacade {
    fun create(dto: CreateCollectionDTO): Collection
    fun get(id: Int): Collection?
    fun list(): List<Collection>
    fun update(id: Int, dto: CreateCollectionDTO): Collection
    fun delete(id: Int)
    fun listDocuments(id: Int): List<Document>
    fun updateDocuments(id: Int, documents: List<PatchEntityDTO>)
}