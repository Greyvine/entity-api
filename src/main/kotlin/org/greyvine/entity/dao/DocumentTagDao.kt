package org.greyvine.entity.dao

import org.apache.ibatis.annotations.*
import org.greyvine.entity.domain.DocumentTag
import org.greyvine.entity.dto.DocumentTagDTO

@Mapper
interface DocumentTagDao {

    @Insert("insert into document_tag(document_id, tag_id, value) values (#{documentId}, #{tagId}, #{value})")
    fun create(documentTag: DocumentTag): Int

    @Delete("delete from document_tag where document_id = #{documentId} and tag_id = #{tagId}")
    fun delete(documentId: Int, tagId: Int): Int

    @Results(value = [
        Result(property = "tag", column = "name"),
    ])
    @Select("select tag.name, value from document_tag join tag on tag_id = id where document_id = #{documentId}")
    fun listByDocumentId(documentId: Int): List<DocumentTagDTO>

}