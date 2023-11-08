package com.andrecastrosousa.service

import com.andrecastrosousa.model.Article

interface BlogService {
    fun listAll() : List<Article>
}