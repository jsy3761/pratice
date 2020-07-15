package com.ntels.syjeon.seoul;

import com.ntels.syjeon.seoul.model.seoul.Row;
import com.ntels.syjeon.seoul.service.ApiService;
import com.ntels.syjeon.seoul.service.SeoulService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;


@SpringBootApplication
public class SeoulApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SeoulApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SeoulApplication.class, args);
	}
}
