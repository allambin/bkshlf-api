package com.example.bkshlf;

import com.example.bkshlf.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Properties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaAuditing
public class BkshlfApplication
{
	public static void main(String[] args)
	{
		SpringApplication application = new SpringApplication(BkshlfApplication.class);
		Properties properties = new Properties();
		properties.setProperty("spring.profiles.active", "local");
		application.setDefaultProperties(properties);

		SpringApplication.run(BkshlfApplication.class, args);
	}
}
