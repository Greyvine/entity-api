package org.greyvine.entity.dao

import org.apache.ibatis.annotations.*
import org.greyvine.entity.domain.Document

@Mapper
interface DocumentDao {

    @Select("select * from document")
    fun list(): List<Document>

    @Select("select * from document join collection_document on document_id = id where collection_id = #{id}")
    fun listByGroupId(id: Int): List<Document>

    @Select("select * from document where id = #{id}")
    fun get(id: Int): Document?

    @Insert("insert into document(name, content) values (#{name}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun create(document: Document): Int

    @Update("update document set name = #{name}, content = #{content} where id = #{id}")
    fun update(document: Document): Int

    @Delete("delete from document where id = #{id}")
    fun delete(id: Int): Int

}