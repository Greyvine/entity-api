package org.greyvine.entity.service

import org.greyvine.entity.dao.CollectionDao
import org.greyvine.entity.domain.Collection
import org.greyvine.entity.extensions.hasTouchedAtLeastOneRow
import org.springframework.stereotype.Service

@Service
class CollectionServiceImpl(
    private val collectionDao: CollectionDao
) : CollectionService {

    override fun list() = collectionDao.list()

    override fun listByDocumentId(id: Int) = collectionDao.listByDocumentId(id)

    override fun get(id: Int) = collectionDao.get(id)

    override fun create(collection: Collection) = collectionDao.create(collection)
        .hasTouchedAtLeastOneRow()
        .let { collection }

    override fun update(collection: Collection) = collectionDao.update(collection)
        .hasTouchedAtLeastOneRow()
        .let { collection }

    override fun delete(id: Int) {
        collectionDao.delete(id)
    }

}