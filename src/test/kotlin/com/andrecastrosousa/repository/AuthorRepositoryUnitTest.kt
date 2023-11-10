package com.andrecastrosousa.repository

import io.micronaut.context.BeanContext
import io.micronaut.data.annotation.Query
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class AuthorRepositoryUnitTest {

    @Inject
    lateinit var beanContext: BeanContext

    @Test
    fun testAnnotationMetadata() {
        val query = beanContext.getBeanDefinition(AuthorRepository::class.java)
            .getRequiredMethod<Any>("findByFirstname", String::class.java)
            .annotationMetadata
            .stringValue(Query::class.java)
            .orElse(null)

        assertEquals(
            "SELECT author_.`id`,author_.`login`,author_.`firstname`,author_.`lastname` FROM `author` author_ WHERE (author_.`firstname` = ?)",
            query
        )
    }
}