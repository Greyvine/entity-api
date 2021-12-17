package org.greyvine.entity.extensions

import org.greyvine.entity.exception.EntityNotFoundException

fun <T> T?.getOrThrow() = this ?: throw EntityNotFoundException("Entity not found")