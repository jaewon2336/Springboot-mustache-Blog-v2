package site.metacoding.blogv2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.blogv2.config.interceptor.SessionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/s/**"); // *, ** 어떨땐 별 하나 어떨 땐 별 두개
    }

    /*
     * @Override
     * public void addInterceptors(InterceptorRegistry registry) {
     * registry.addInterceptor(new SessionInterceptor())
     * .addPathPatterns("/s/*")
     * .addPathPatterns("/user/*")
     * .excludePathPatterns("/s/post/*")
     * }
     */
}
