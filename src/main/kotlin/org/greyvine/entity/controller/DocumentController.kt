package org.greyvine.entity.controller

import org.greyvine.entity.dto.CreateDocumentDTO
import org.greyvine.entity.dto.PatchEntityDTO
import org.greyvine.entity.facade.DocumentFacade
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/documents")
class DocumentController(
    private val documentFacade: DocumentFacade
) {

    @GetMapping
    fun list() = documentFacade.list()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = documentFacade.get(id)

    @PostMapping
    fun create(@Validated @RequestBody dto: CreateDocumentDTO) = documentFacade.create(dto)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun get(@PathVariable id: Int, @RequestBody dto: CreateDocumentDTO) = documentFacade.update(id, dto)

    @GetMapping("/{id}/collections")
    fun listDocuments(@PathVariable id: Int) = documentFacade.listCollections(id)

    @PatchMapping("/{id}/collections")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDocuments(@PathVariable id: Int, @RequestBody entities: List<PatchEntityDTO>) =
        documentFacade.updateCollections(id, entities)

    @GetMapping("/{id}/tags")
    fun listTags(@PathVariable id: Int) = documentFacade.listTags(id)

}