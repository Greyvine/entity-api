package org.greyvine.entity.dto

import javax.validation.constraints.NotNull

class CreateDocumentDTO {
    @NotNull
    var name: String? = null

    @NotNull
    var content: String? = null
}