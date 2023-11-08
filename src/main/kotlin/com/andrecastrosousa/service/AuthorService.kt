package com.andrecastrosousa.service

import com.andrecastrosousa.model.Author

interface AuthorService {
    fun listAll() : List<Author>
}