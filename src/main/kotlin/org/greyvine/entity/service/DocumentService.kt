package org.greyvine.entity.service

import org.greyvine.entity.domain.Document

interface DocumentService {
    fun list(): List<Document>
    fun listByGroupId(id: Int): List<Document>
    fun get(id: Int): Document?
    fun create(document: Document): Document
    fun update(document: Document): Document
    fun delete(id: Int)
}