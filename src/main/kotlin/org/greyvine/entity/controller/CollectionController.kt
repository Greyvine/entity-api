package org.greyvine.entity.controller

import org.greyvine.entity.dto.CreateCollectionDTO
import org.greyvine.entity.dto.PatchEntityDTO
import org.greyvine.entity.facade.CollectionFacade
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/collections")
class CollectionController(
    private val collectionFacade: CollectionFacade
) {

    @GetMapping
    fun list() = collectionFacade.list()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = collectionFacade.get(id)

    @PostMapping
    fun create(@RequestBody dto: CreateCollectionDTO) = collectionFacade.create(dto)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun get(@PathVariable id: Int, @RequestBody dto: CreateCollectionDTO) = collectionFacade.update(id, dto)

    @GetMapping("/{id}/documents")
    fun listDocuments(@PathVariable id: Int) = collectionFacade.listDocuments(id)

    @PatchMapping("/{id}/documents")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDocuments(@PathVariable id: Int, @RequestBody entities: List<PatchEntityDTO>) =
        collectionFacade.updateDocuments(id, entities)

}