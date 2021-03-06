package com.mijiaokj.sys.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sunchenguang on 2017/6/6.
 * 该过滤器的主要作用就是通过spring著名的IoC生成securityMetadataSource。
 * securityMetadataSource相当于本包中自定义的MijiaoInvocationSecurityMetadataSource。
 * 该MijiaoInvocationSecurityMetadataSource的作用提从数据库提取权限和资源，装配到HashMap中，
 * 供Spring Security使用，用于权限校验。
 */
@Component
public class AbstractSecurityInterceptorFilter extends AbstractSecurityInterceptor implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MijiaoInvocationSecurityMetadataSource  mijiaoInvocationSecurityMetadataSource;

    @Autowired
    private MijiaoAccessDecisionManager mijiaoAccessDecisionManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init(){
        super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(mijiaoAccessDecisionManager);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation( request, response, chain );
        invoke(fi);
    }

    @Override
    public Class<? extends Object> getSecureObjectClass(){
        return FilterInvocation.class;
    }

    public void invoke( FilterInvocation fi ) throws IOException, ServletException{
        logger.info("filter..........................");
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try{
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally{
            super.afterInvocation(token, null);
        }
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource(){
        return this.mijiaoInvocationSecurityMetadataSource;
    }
    @Override
    public void destroy(){
        logger.info("filter..........................end");
    }
    @Override
    public void init( FilterConfig filterconfig ) throws ServletException{
        logger.info("filter..........................init");
    }
}
