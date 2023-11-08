package com.andrecastrosousa.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@MappedEntity
class Author(
    var login: String,
    var firstname: String,
    var lastname: String,
    @field:Id
    @field:GeneratedValue
    var id: Long? = null) {
}