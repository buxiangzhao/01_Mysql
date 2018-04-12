package com.bxz;

import com.bxz.intercptor.LoggerInterceptor;
import com.bxz.intercptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/7
 * Time：21:47
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Configuration
public class CommonConfiguration extends WebMvcConfigurerAdapter
{
    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }

    /**
     * 静态文件配置
     * http://localhost:8080/bxz/resources/gaoxiao.jpg 转译成
     * http://localhost:8080/gaoxiao.jpg
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bxz/resources/**").addResourceLocations("classpath:/static/");
    }
}
