package com.example.demo.configs;


import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;



@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//       registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
//
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/edit").setViewName("/editthreeform");
        registry.addViewController("/inputqualityinfo").setViewName("/inputqualityinfo");
        registry.addViewController("/findtest").setViewName("/findtest");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/register").setViewName("/register");
        registry.addViewController("/changepassword").setViewName("/changepassword");
        registry.addViewController("/table").setViewName("/table");
    }

    @Override//通过重写下列方法，可以忽略参数获取中的.
    public void configurePathMatch(PathMatchConfigurer configurer){
        configurer.setUseSuffixPatternMatch(false);
    }

}

