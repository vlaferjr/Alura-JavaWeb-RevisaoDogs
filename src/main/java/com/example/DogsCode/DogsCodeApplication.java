package com.example.DogsCode;

import com.example.DogsCode.models.Racas;
import com.example.DogsCode.models.RespostaRacas;
import com.example.DogsCode.principal.Principal;
import com.example.DogsCode.services.ConsumoApiService;
import com.example.DogsCode.services.converteDadosService.ConverteDadosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogsCodeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DogsCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		//chamada para o menu
		principal.menu();
	}
}
