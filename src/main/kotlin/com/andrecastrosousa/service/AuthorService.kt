package com.andrecastrosousa.service

import com.andrecastrosousa.model.Author
import io.micronaut.core.annotation.NonNull
import jakarta.validation.constraints.NotNull

interface AuthorService {
    fun listAll() : List<Author>
    fun getById(@NotNull @NonNull id: Long) : Author
    fun create(@NotNull @NonNull author: Author) : Author
    fun update(@NotNull @NonNull id: Long, @NotNull @NonNull author: Author) : Author
    fun deleteById(@NotNull @NonNull id: Long)
}