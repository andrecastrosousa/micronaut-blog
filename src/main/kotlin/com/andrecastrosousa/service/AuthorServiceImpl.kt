package com.andrecastrosousa.service

import com.andrecastrosousa.model.Author
import com.andrecastrosousa.repository.AuthorRepository

class AuthorServiceImpl (private val authorRepository: AuthorRepository) : AuthorService {
    override fun listAll() : List<Author> {
        return authorRepository.findAll().toList();
    }

    override fun getById(id: Long): Author {
        return authorRepository.findById(id).get()
    }

    override fun create(author: Author): Author {
        return authorRepository.save(author)
    }

    override fun update(id: Long, author: Author): Author {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        authorRepository.deleteById(id);
    }
}