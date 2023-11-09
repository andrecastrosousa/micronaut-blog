package com.andrecastrosousa.repository

import com.andrecastrosousa.model.Author
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Id
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository
import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@JdbcRepository(dialect = Dialect.MYSQL)
abstract class AuthorRepository : PageableRepository<Author, Long> {
    abstract fun save(@NotBlank author: Author) : Author

    @Transactional
    open fun saveWithException(@NotBlank author: Author) : Author {
        save(author)
        throw DataAccessException("test exception")
    }
}