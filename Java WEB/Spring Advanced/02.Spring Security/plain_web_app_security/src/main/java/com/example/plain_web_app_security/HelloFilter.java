package com.example.plain_web_app_security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(             //задължителна анотация, за да работи като web filter
        urlPatterns = "/hello-servlet"
)
public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("username", "Peshko");
        chain.doFilter(request, response);
    }
}
