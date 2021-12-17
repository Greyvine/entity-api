package org.greyvine.entity.service

import org.greyvine.entity.domain.Tag

interface TagService {
    fun list(): List<Tag>
    fun upsert(tag: Tag): Tag
    fun listByDocumentId(id: Int): List<Tag>
}