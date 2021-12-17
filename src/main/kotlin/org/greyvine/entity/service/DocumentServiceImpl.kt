package org.greyvine.entity.service

import org.greyvine.entity.dao.DocumentDao
import org.greyvine.entity.domain.Document
import org.greyvine.entity.extensions.hasTouchedAtLeastOneRow
import org.springframework.stereotype.Service

@Service
class DocumentServiceImpl(
    private val documentDao: DocumentDao
) : DocumentService {

    override fun list() = documentDao.list()

    override fun listByGroupId(id: Int) = documentDao.listByGroupId(id)

    override fun get(id: Int) = documentDao.get(id)

    override fun create(document: Document) = documentDao.create(document)
        .hasTouchedAtLeastOneRow()
        .let { document }

    override fun update(document: Document) = documentDao.update(document)
        .hasTouchedAtLeastOneRow()
        .let { document }

    override fun delete(id: Int) { documentDao.delete(id) }

}