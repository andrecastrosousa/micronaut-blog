package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Author
import com.andrecastrosousa.service.AuthorService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/api/authors")
class AuthorController(private val authorService: AuthorService) {
    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun listAll() : List<Author> {
        return authorService.listAll()
    }
}