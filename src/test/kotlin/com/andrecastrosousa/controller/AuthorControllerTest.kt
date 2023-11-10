package com.andrecastrosousa.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.validation.Valid
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class AuthorControllerTest(@Client("/") val client: HttpClient) {
    @Test
    fun `When someone want to get author information`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/authors")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals(0, body.length)
    }
}