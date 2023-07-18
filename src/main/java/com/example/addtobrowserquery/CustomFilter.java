package com.example.addtobrowserquery;

import jakarta.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // Ваш код для перехвата и обработки запроса
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        String remoteAddr = request.getRemoteAddr();

        System.out.println(method + uri + query + remoteAddr);

        // Пропускаем запрос дальше по цепочке фильтров
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Очистка ресурсов фильтра
    }
}
