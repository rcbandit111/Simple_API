package org.datalis.rest.api.server.config;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@SpringBootApplication(scanBasePackages = { "org.datalis.rest.api.*" })
public class Application extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.removeIf(converter -> converter instanceof MappingJackson2XmlHttpMessageConverter);
		converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
		converters.add(new MappingJackson2XmlHttpMessageConverter(
				((XmlMapper) createObjectMapper(Jackson2ObjectMapperBuilder.xml()))
						.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION)));
		converters.add(new MappingJackson2HttpMessageConverter(createObjectMapper(Jackson2ObjectMapperBuilder.json())));
	}

	private ObjectMapper createObjectMapper(Jackson2ObjectMapperBuilder builder) {
		builder.indentOutput(true);
		builder.modules(new JaxbAnnotationModule());
		builder.serializationInclusion(JsonInclude.Include.NON_NULL);
		builder.defaultUseWrapper(false);
		return builder.build();
	}
}
