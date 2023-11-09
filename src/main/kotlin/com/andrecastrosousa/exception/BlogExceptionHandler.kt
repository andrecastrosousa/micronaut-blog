package com.andrecastrosousa.exception

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Produces
@Singleton
@Requires(classes = [BlogException::class, NoAuthorFoundException::class])
class BlogExceptionHandler : ExceptionHandler<BlogException, MutableHttpResponse<String?>?> {
    override fun handle(request: HttpRequest<Any>, exception: BlogException): MutableHttpResponse<String?>? {
        return HttpResponse.notFound(exception.message)

    }
}