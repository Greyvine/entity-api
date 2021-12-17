package org.greyvine.entity.service

import org.greyvine.entity.dao.DocumentTagDao
import org.greyvine.entity.domain.Document
import org.greyvine.entity.domain.DocumentTag
import org.greyvine.entity.extensions.hasTouchedAtLeastOneRow
import org.springframework.stereotype.Service

@Service
class DocumentTagServiceImpl(
    private val documentTagDao: DocumentTagDao
) : DocumentTagService {
    override fun create(documentTag: DocumentTag) = documentTagDao.create(documentTag)
        .hasTouchedAtLeastOneRow()
        .let { documentTag }

    override fun listByDocumentId(id: Int) = documentTagDao.listByDocumentId(id)
}