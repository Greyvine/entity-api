package org.greyvine.entity.service

import org.greyvine.entity.domain.Collection

interface CollectionService {
    fun list(): List<Collection>
    fun listByDocumentId(id: Int): List<Collection>
    fun get(id: Int): Collection?
    fun create(collection: Collection): Collection
    fun update(collection: Collection): Collection
    fun delete(id: Int)
}