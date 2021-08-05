package gy.finolo.springbootmybatisplus.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Simon
 * @date: 2021-07-29 14:34
 */
@Configuration
// 开启Swagger3
@EnableOpenApi
public class SwaggerConfig {

    @Autowired
    private Environment environment;

    // 配置Docket实例
    @Bean
    public Docket docket() {

        Profiles profiles = Profiles.of("dev");

        boolean isDevEnvironment = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // 是否启动Swagger, 默认true
                .enable(isDevEnvironment)
                .select()
                // 配置扫描接口
                .apis(RequestHandlerSelectors.basePackage("gy.finolo.springbootmybatisplus.controller"))
                // 路径扫描
                .paths(PathSelectors.any())
                .build();
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
    }

    // 配置Swagger信息
    private ApiInfo apiInfo() {

        // 作者信息
        Contact contact = new Contact("Simon", "url", "email");
        return new ApiInfoBuilder()
                .title("SwaggerAPI的Title")
                .description("API介绍")
                .version("v1.0")
                .contact(contact)
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(
                new ApiKey("Authorization", "MyAuthorization", "header")
        );
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .operationSelector(operationContext -> {
                            System.out.println("----------");
                            System.out.println(operationContext.requestMappingPattern());
                            System.out.println(operationContext.requestMappingPattern().matches("^(?!/auth).*$"));
                            return operationContext.requestMappingPattern().matches("^(?!/auth).*$");
                        })
                        .build()
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        return Collections.singletonList(
                new SecurityReference("Authorization", new AuthorizationScope[]{authorizationScope})
        );
    }

    public static void main(String[] args) {

        System.out.println("/authxxx".matches("^(?!/auth).*"));
    }
}
