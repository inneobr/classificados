package org.inneo.classificados;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RunApplication {
	@Value("${server.port}")	
	private static String serverPort;
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
		log.info("server port: {}", serverPort);
	}

}
