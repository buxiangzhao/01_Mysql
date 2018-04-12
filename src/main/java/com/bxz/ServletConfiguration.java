package com.bxz;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan //自动扫描serlvet
public class ServletConfiguration {

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean()
//    {
//        return new ServletRegistrationBean(new TestServlet(),"/test");
//    }
}
