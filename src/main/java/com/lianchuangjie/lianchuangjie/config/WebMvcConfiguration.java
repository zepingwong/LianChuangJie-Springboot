package com.lianchuangjie.lianchuangjie.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.validation.constraints.NotNull;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Value("${localImgPath}")
    private String localImgPath;

    @Value("${staticAccessPath}")
    private String staticAccessPath;


    // SpringBoot的HandlerInterceptor依赖注入一直为 null
    // 拦截器的加载是在 springcontext 创建之前完成的。这里让bean提前加载就可以注入成功了
    @Bean
    public AuthenticationInterpreter AuthenticationInterpreter() {
        return new AuthenticationInterpreter();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.AuthenticationInterpreter())
                // 拦截的路径 需要进行token验证的路径
                .addPathPatterns("/**")
                // 放行的路径
                .excludePathPatterns("/user/login/**")
                .excludePathPatterns("/user/register");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + localImgPath);
        super.addResourceHandlers(registry);
    }


    @Override
    protected void configureMessageConverters(@org.jetbrains.annotations.NotNull @NotNull List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
    }

    // 解决序列化空对象问题
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        // 关键代码
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return new MappingJackson2HttpMessageConverter(mapper);
    }
}
