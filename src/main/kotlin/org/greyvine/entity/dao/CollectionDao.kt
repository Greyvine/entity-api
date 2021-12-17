package org.greyvine.entity.dao

import org.apache.ibatis.annotations.*
import org.greyvine.entity.domain.Collection

@Mapper
interface CollectionDao {

    @Select("select * from collection")
    fun list(): List<Collection>

    @Select("select * from collection join collection_document on collection_id = id where document_id = #{id}")
    fun listByDocumentId(id: Int): List<Collection>

    @Select("select * from collection where id = #{id}")
    fun get(id: Int): Collection?

    @Insert("insert into collection(name) values (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun create(collection: Collection): Int

    @Update("update collection set name = #{name} where id = #{id}")
    fun update(collection: Collection): Int

    @Delete("delete from collection where id = #{id}")
    fun delete(id: Int): Int

}