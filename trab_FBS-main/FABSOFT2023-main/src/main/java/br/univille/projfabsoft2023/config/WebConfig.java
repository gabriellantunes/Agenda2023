package br.univille.projfabsoft2023.config;

import br.univille.projfabsoft2023.interceptor.NoCacheInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private NoCacheInterceptor noCacheInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(noCacheInterceptor)
                .addPathPatterns("/dashboard/**")
                .addPathPatterns("/lembretes/**");
    }
}
