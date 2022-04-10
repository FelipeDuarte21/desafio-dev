package br.com.luizfelipe.backend.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.luizfelipe.backend.controller"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.useDefaultResponseMessages(false)
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("API do Sistema de Leitor de Arquivo CNAB")
				.description("API do Sistema de Leitor de Arquivo CNAB")
				.version("1.0.0")
				.license("Licença Pública Geral GNU")
				.licenseUrl("https://www.gnu.org/licenses/gpl-3.0.html")
				.contact(new Contact("Luiz Felipe Duarte Elias", "", "felipe15lfde@gmail.com"))
				.build();
	}
	
}
