package com.andrecastrosousa.service

import com.andrecastrosousa.exception.NoAuthorFoundException
import com.andrecastrosousa.model.Author
import com.andrecastrosousa.repository.AuthorRepository
import java.util.Optional

class AuthorServiceImpl (private val authorRepository: AuthorRepository) : AuthorService {
    override fun listAll() : List<Author> {
        return authorRepository.findAll().toList();
    }

    override fun getById(id: Long): Author {
        val optionalAuthor: Optional<Author> = authorRepository.findById(id)
        if (optionalAuthor.isEmpty) {
            throw NoAuthorFoundException("Author not found")
        }
        return optionalAuthor.get()
    }

    override fun create(author: Author): Author {
        return authorRepository.save(author)
    }

    override fun update(id: Long, author: Author): Author {
        val optionalAuthor: Optional<Author> = authorRepository.findById(id)
        if (optionalAuthor.isEmpty) {
            throw NoAuthorFoundException("Author not found")
        }

        val foundAuthor: Author = optionalAuthor.get()
        foundAuthor.firstname = author.firstname
        foundAuthor.lastname = author.lastname

        return authorRepository.save(foundAuthor)
    }

    override fun deleteById(id: Long) {
        authorRepository.deleteById(id);
    }
}