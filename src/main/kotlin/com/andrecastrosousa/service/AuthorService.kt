package com.andrecastrosousa.service

import com.andrecastrosousa.model.Author
import io.micronaut.core.annotation.NonNull
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

interface AuthorService {
    fun listAll() : List<Author>
    fun getById(@NotBlank id: Long) : Author
    fun create(@NotBlank author: Author) : Author
    fun update(@NotNull @NonNull id: Long, @NotBlank author: Author) : Author
    fun deleteById(@NotNull @NonNull id: Long)
}