package com.andrecastrosousa.service

import com.andrecastrosousa.model.Author
import com.andrecastrosousa.repository.AuthorRepository

class AuthorServiceImpl (val authorRepository: AuthorRepository) : AuthorService {
    override fun listAll() : List<Author> {
        return authorRepository.findAll().toList();
    }
}