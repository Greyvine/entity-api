package org.greyvine.entity.dto

import javax.validation.constraints.NotNull

class CreateCollectionDTO {
    @NotNull
    var name: String? = null
}