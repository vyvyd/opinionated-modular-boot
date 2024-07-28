package com.demo.opinionatedmodularboot.logging

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jdk.incubator.vector.VectorOperators.LOG
import org.springframework.web.filter.OncePerRequestFilter


class RequestTimingFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        // logic for timing the request
        chain.doFilter(request, response)
    }
}