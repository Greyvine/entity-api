package org.greyvine.entity.facade

import org.greyvine.entity.domain.Collection
import org.greyvine.entity.dto.CreateCollectionDTO
import org.greyvine.entity.dto.PatchEntityDTO
import org.greyvine.entity.extensions.getOrThrow
import org.greyvine.entity.service.DocumentService
import org.greyvine.entity.service.CollectionDocumentService
import org.greyvine.entity.service.CollectionService
import org.springframework.stereotype.Service

@Service
class CollectionFacadeImpl(
    private val collectionService: CollectionService,
    private val documentService: DocumentService,
    private val collectionDocumentService: CollectionDocumentService,
) : CollectionFacade {

    override fun list() = collectionService.list()

    override fun update(id: Int, dto: CreateCollectionDTO) =
        dto.toGroup()
            .apply { this.id = id }
            .let { collectionService.update(it) }

    override fun delete(id: Int) {
        collectionService.delete(id)
    }

    override fun listDocuments(id: Int) = documentService.listByGroupId(id)

    override fun updateDocuments(id: Int, documents: List<PatchEntityDTO>) {
        documents
            .filter { it.add == true }
            .forEach { collectionDocumentService.create(id, it.id!!) }

        documents
            .filter { it.add == false }
            .forEach { collectionDocumentService.delete(id, it.id!!)  }
    }

    override fun get(id: Int) = collectionService.get(id).getOrThrow()

    override fun create(dto: CreateCollectionDTO) = collectionService.create(dto.toGroup())

    companion object {
        fun CreateCollectionDTO.toGroup() = Collection().apply {
            this.name = this@toGroup.name
        }
    }

}