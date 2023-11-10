package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Author
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class AuthorControllerTest(@Client("/") val client: HttpClient) {
    @Test
    fun `When someone want to get authors list`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/authors")
        val body = client.toBlocking().retrieve(request)
        println(body)
        assertNotNull(body)
        assertEquals(3, body.size)
    }

    @Test
    fun `When someone want to get a specific author`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/authors/1")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
    }

    @Test
    fun `When someone want to create author`() {
        val author = Author("andresousa23", "Andre", "Sousa")
        val request: HttpRequest<Any> = HttpRequest.POST("/api/authors", author)
        val body = client.toBlocking().retrieve(request)

        assertNotNull(body)
        println(body)
    }
}