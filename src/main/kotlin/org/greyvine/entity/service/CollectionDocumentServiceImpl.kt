package org.greyvine.entity.service

import org.greyvine.entity.dao.CollectionDocumentDao
import org.springframework.stereotype.Service

@Service
class CollectionDocumentServiceImpl(
    private val collectionDocumentDao: CollectionDocumentDao
) : CollectionDocumentService {

    override fun create(collectionId: Int, documentId: Int) =
        collectionDocumentDao.create(collectionId, documentId)

    override fun delete(collectionId: Int, documentId: Int) =
        collectionDocumentDao.delete(collectionId, documentId)

}