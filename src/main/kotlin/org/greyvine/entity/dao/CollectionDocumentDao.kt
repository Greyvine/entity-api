package org.greyvine.entity.dao

import org.apache.ibatis.annotations.*

@Mapper
interface CollectionDocumentDao {

    @Insert("insert into collection_document(collection_id, document_id) values (#{collectionId}, #{documentId})")
    fun create(collectionId: Int, documentId: Int): Int

    @Delete("delete from collection_document where collection_id = #{collectionId} and document_id = #{documentId}")
    fun delete(collectionId: Int, documentId: Int): Int

}