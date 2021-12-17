package org.greyvine.entity.service

interface CollectionDocumentService {
    fun create(collectionId: Int, documentId: Int): Int
    fun delete(collectionId: Int, documentId: Int): Int
}