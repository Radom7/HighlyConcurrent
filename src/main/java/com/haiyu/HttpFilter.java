package com.haiyu;

import com.haiyu.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Title: HttpFilter
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 15:37
 */
@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        log.info("do filter,{},{}",Thread.currentThread().getId(),request1.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
