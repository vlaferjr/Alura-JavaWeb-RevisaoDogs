package com.example.DogsCode;

import com.example.DogsCode.models.Racas;
import com.example.DogsCode.models.RespostaRacas;
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
		var consumoApiService = new ConsumoApiService();
		//método obterDados de ConsumoApiService
		var json = consumoApiService.obterDados("https://dogapi.dog/api/v2/breeds");
		//imprimindo json
		System.out.println(json);

		/*usando o converson*/
		ConverteDadosService converteDados = new ConverteDadosService();
		/*dados convertidos recebe os dados convertidos pelo converteDadosService*/
		RespostaRacas dadosConvertidos = converteDados.obterDados(json, RespostaRacas.class);

		System.out.println(dadosConvertidos);;
	}
}
