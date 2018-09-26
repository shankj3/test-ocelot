package com;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Starting point for the Example Boot application
 *
 * This project reads JVM properties - before starting add -D=serviceUrl="http://localhost:8080" as a JVM argument
 *
 * You can all specify where you would like your log files to be saved with the following JVM argument:
 * -Dlogging.file="/home/mariannefeng/git/trident/mylog.log"
 *
 * Currently, the custom logback configuration is automatically found by Spring because there's a copy in the resources folder.
 * But if the below JVM argument is set, any logback xml configuration files can be passed in via JVM argument
 * -Dlogging.config="/home/mariannefeng/git/trident/logback-spring.xml"
 *
 *
 * Created by mariannefeng on 6/8/16.
 */
@SpringBootApplication
@EnableSwagger2
public class Application extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private Environment env;

    private Map<String, String> getAppProps() {
        Map<String, String> props = new HashMap<>();
        for(PropertySource ps : ((AbstractEnvironment) env).getPropertySources())
        {
            if (ps.getName().contains("application.properties"))
            {
                for (String name : ((PropertiesPropertySource) ps).getPropertyNames())
                {
                    props.put(name, env.getProperty(name));
                }
            }
        }
        return props;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(false)
                        .allowedOrigins("*")
                        .allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE", "PUSH", "HEAD", "PATCH")
                        .exposedHeaders("Authorization", "Content-Type");
            }
        };
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("v2/api-docs")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Example Boot app")
                .version("1")
                .description("Example Spring Boot App")
                .build();
    }

    private Predicate<String> paths() {
        return or(
                regex("/v1.*"),
                regex("/status")
        );
    }

}