package org.greyvine.entity.service

import org.greyvine.entity.dao.CollectionDao
import org.greyvine.entity.dao.TagDao
import org.greyvine.entity.domain.Collection
import org.greyvine.entity.domain.Tag
import org.greyvine.entity.extensions.hasTouchedAtLeastOneRow
import org.springframework.stereotype.Service

@Service
class TagServiceImpl(
    private val tagDao: TagDao
) : TagService {

    override fun list() = tagDao.list()

    override fun upsert(tag: Tag) = tagDao.upsert(tag)
            .hasTouchedAtLeastOneRow()
            .let { tag }

    override fun listByDocumentId(id: Int) = tagDao.listByDocumentId(id)

}