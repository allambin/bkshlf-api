package com.example.bkshlf;

import com.example.bkshlf.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(RsaKeyProperties.class)
public class BkshlfApplication
{
	public static void main(String[] args) {
		SpringApplication.run(BkshlfApplication.class, args);
	}
}
