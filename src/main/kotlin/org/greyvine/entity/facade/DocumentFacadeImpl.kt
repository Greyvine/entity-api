package org.greyvine.entity.facade

import org.greyvine.entity.domain.Document
import org.greyvine.entity.domain.DocumentTag
import org.greyvine.entity.domain.Tag
import org.greyvine.entity.dto.CreateDocumentDTO
import org.greyvine.entity.dto.PatchEntityDTO
import org.greyvine.entity.extensions.getOrThrow
import org.greyvine.entity.service.*
import org.greyvine.tags.service.AnnotationService
import org.springframework.stereotype.Service

@Service
class DocumentFacadeImpl(
    private val documentService: DocumentService,
    private val collectionService: CollectionService,
    private val collectionDocumentService: CollectionDocumentService,
    private val annotationService: AnnotationService,
    private val tagService: TagService,
    private val documentTagService: DocumentTagService,
) : DocumentFacade {

    override fun list() = documentService.list()

    override fun update(id: Int, dto: CreateDocumentDTO) =
        dto.toDocument()
            .apply { this.id = id }
            .let { documentService.update(it) }

    override fun delete(id: Int) {
        documentService.delete(id)
    }

    override fun get(id: Int) = documentService.get(id).getOrThrow()

    override fun create(dto: CreateDocumentDTO) =
        documentService.create(dto.toDocument())
            .also { upsertTags(it) }

    private fun upsertTags(document: Document) {
        val annotation = annotationService.annotate(document.content!!)
        annotation.annotations.forEach {
            val tag = tagService.upsert(Tag().apply { name = it.name })
            val documentTag = DocumentTag().apply {
                documentId = document.id
                tagId = tag.id
                value = it.value
            }
            documentTagService.create(documentTag)
        }
    }

    override fun listCollections(id: Int) = collectionService.listByDocumentId(id)

    override fun updateCollections(id: Int, groups: List<PatchEntityDTO>) {
        groups
            .filter { it.add == true }
            .forEach { collectionDocumentService.create(it.id!!, id) }

        groups
            .filter { it.add == false }
            .forEach { collectionDocumentService.delete(it.id!!, id)  }
    }

    override fun listTags(id: Int) = documentTagService.listByDocumentId(id)

    companion object {
        fun CreateDocumentDTO.toDocument() = Document().apply {
            this.name = this@toDocument.name
            this.content = this@toDocument.content
        }
    }

}