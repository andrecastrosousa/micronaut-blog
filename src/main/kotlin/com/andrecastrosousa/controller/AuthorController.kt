package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Author
import com.andrecastrosousa.service.AuthorService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Put
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank

@Controller("/api/authors")
class AuthorController(private val authorService: AuthorService) {
    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun listAll() : List<Author> {
        return authorService.listAll()
    }

    @Get("/{id}")
    fun getById(id: Long) : Author {
        return authorService.getById(id)
    }

    @Post
    fun create(@Body author: Author) : Author {
        return authorService.create(author)
    }

    @Put("/{id}")
    fun update(id: Long, @Body author: Author): Author {
        return authorService.update(id, author)
    }

    @Delete("/{id}")
    fun delete(id: Long) {
        authorService.deleteById(id)
    }
}