package com.jett.springcloud.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="customFilter",urlPatterns={"/*"})
@Slf4j
public class CustomFilter  implements Filter {
    private static final  String URI="dept";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化完成!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter请求处理!");
        String remoteAddr = servletRequest.getRemoteHost();
        int remotePort= servletRequest.getRemotePort();
        String basePath=servletRequest.getServerName();
        int    basePort=servletRequest.getServerPort();
        String path = ((HttpServletRequest)servletRequest).getServletPath();
        log.info("远程IP,Port:["+remoteAddr+":"+remotePort+"]");
        log.info("filter->path:"+basePath+";"+basePort+path);
        if ( path.endsWith("/")) {
            servletRequest.getRequestDispatcher(path + URI).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁！");
    }
}
