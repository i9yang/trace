package ssg.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SsgSearchTraceWebappApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsgSearchTraceWebappApplication.class, args);
	}

	@Bean
	public ObjectMapper jacksonObjectMapper() {
		return new ObjectMapper().setPropertyNamingStrategy(
				PropertyNamingStrategy.LOWER_CASE);
	}
}
