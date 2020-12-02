package com.zsy.blog.config;

import com.zsy.blog.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-12-02 15:51
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean shiroFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        registration.addInitParameter("targetFilterLifecycle","true");
        registration.setEnabled(true);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean xssFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}
