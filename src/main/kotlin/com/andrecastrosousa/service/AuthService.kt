package com.andrecastrosousa.service

import com.andrecastrosousa.model.Author

interface AuthService {
    fun listAll() : List<Author>
}