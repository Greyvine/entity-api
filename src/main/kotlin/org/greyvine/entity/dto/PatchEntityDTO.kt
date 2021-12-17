package org.greyvine.entity.dto

import javax.validation.constraints.NotNull

class PatchEntityDTO {
    @NotNull
    var id: Int? = null

    @NotNull
    var add: Boolean? = null
}