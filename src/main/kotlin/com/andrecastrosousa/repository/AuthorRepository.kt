package com.andrecastrosousa.repository

import com.andrecastrosousa.model.Author
import io.micronaut.data.annotation.Repository
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.data.repository.CrudRepository
import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotBlank

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {
    fun save(@NotBlank author: Author) : Author

    fun findByFirstname(firstname: String): Author

    @Transactional
    fun saveWithException(@NotBlank author: Author) : Author {
        save(author)
        throw DataAccessException("test exception")
    }
}