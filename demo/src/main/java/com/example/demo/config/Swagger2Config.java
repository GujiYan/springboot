package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    // 访问网址：http://ip:port/demo/swagger-ui.html

    private final String PATH = "com.example.demo.controller";

    /*
        @Api：修饰整个类，描述Controller的作用
        @ApiOperation：描述一个类的一个方法，或者说一个接口
        @ApiParam：单个参数描述
        @ApiModel：用对象来接收参数
        @ApiProperty：用对象接收参数时，描述对象的一个字段
        @ApiResponse：HTTP响应其中1个描述
        @ApiResponses：HTTP响应整体描述
        @ApiIgnore：使用该注解忽略这个API
        @ApiError ：发生错误返回的信息
        @ApiParamImplicitL：一个请求参数
        @ApiParamsImplicit 多个请求参数
    */

    @Bean
    public Docket creatRestApi(){
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameters.add(parameterBuilder.build());
        
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(PATH))//指定包
                .paths(PathSelectors.any()).build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("app-demo 接口文档")//标题
                .description("内部使用")//描述
                .version("1.0.0")//版本
                .build();
    }

}
