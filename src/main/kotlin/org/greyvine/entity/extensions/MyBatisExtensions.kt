package org.greyvine.entity.extensions

import org.greyvine.entity.exception.EntityNotFoundException

fun Int.hasTouchedAtLeastOneRow() =
    if (this < 1) throw EntityNotFoundException()
    else 0