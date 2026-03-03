package com.jose.curso.spring.app1_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class App1DemoApplication {

	@Autowired
	private NotificacionService notificacionService;

	public static void main(String[] args) {
		SpringApplication.run(App1DemoApplication.class, args);
	}

	@GetMapping("/mensaje")
	public String getMethodName(@RequestParam String param) {
		return notificacionService.enviarNotificacion();
	}
	

}
