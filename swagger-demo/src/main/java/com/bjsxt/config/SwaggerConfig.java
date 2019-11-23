package com.bjsxt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

/**
 * @author lvyelanshan
 * @create 2019-11-23 10:14
 */
@Configuration
public class SwaggerConfig {

    /**
     * 返回文档对象
     * Docket：摘要对象，通过对象配置描述文件的信息。
     * apiInfo:设置描述文件中 info。参数类型 ApiInfo
     * select():返回 ApiSelectorBuilder 对象，通过对象调用 build()可以
     * 创建 Docket 对象
     * ApiInfoBuilder：ApiInfo 构建器。
     * apis(RequestHandlerSelectors.basePackage("com.bjsxt.controller")):指定需要扫描的包，需要生成api的包
     * @return
     */
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).
                select().apis(RequestHandlerSelectors.basePackage("com.bjsxt.controller"))
                .apis(not(withMethodAnnotation(NotIncludeSwagger.class))) //表示这个注解下的方法不生成api文档
                .paths(PathSelectors.regex("/people/.*")) //表示这个请求路径下的方法才被生成api文档
                .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("标题设置").version("2.0").description("描述信息")
                .contact(new Contact("绿野蓝杉","http://www.baidu.com","1049649419@qq.com")).build();
    }

}
