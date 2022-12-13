package lt.codeacademy.invoice.configs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(ourApiInfo());
    }
    
    private ApiInfo ourApiInfo() {
        return new ApiInfo(
          "Invoices Generator API v0.0.1", 
          "Our Generator creates invoices out of customers and items.", 
          "Our terms of service are pretty loose", 
          "Terms of service", 
         
          new Contact("Deimis Čekanauskas", "www.google.com", "tikras@email.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
}
 