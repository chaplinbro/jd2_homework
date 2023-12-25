package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    // Конфигурация для HTML контроллера
    @Bean
    public InternalResourceViewResolver htmlViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Ресурсы для представлений из директории /WEB-INF/views/
        registry.addResourceHandler("/WEB-INF/views/**")
                .addResourceLocations("/WEB-INF/views/");
    }


    // Конфигурация для JSP контроллера
//    @Bean
//    public InternalResourceViewResolver jspViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//
//        @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        // Ресурсы для представлений из директории /WEB-INF/views/
//        registry.addResourceHandler("/WEB-INF/jsp/**")
//                .addResourceLocations("/WEB-INF/jsp/");
//    }

}