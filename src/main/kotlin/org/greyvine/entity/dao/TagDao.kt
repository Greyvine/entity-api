package org.greyvine.entity.dao

import org.apache.ibatis.annotations.*
import org.greyvine.entity.domain.Collection
import org.greyvine.entity.domain.Document
import org.greyvine.entity.domain.Tag

@Mapper
interface TagDao {

    @Select("select * from tag")
    fun list(): List<Tag>

    @Insert("insert into tag(name) values (#{name}) on conflict (name) do update set name = excluded.name returning *")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun upsert(tag: Tag): Int

    @Select("select * from tag join document_tag on tag_id = id where document_id = #{id}")
    fun listByDocumentId(id: Int): List<Tag>

}