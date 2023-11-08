package com.andrecastrosousa.controller.service

import com.andrecastrosousa.model.Article

interface BlogService {
    fun listAll() : List<Article>
}