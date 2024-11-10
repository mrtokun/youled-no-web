package br.com.tokun.youled;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tokun.youled.model.DadosSerie;
import br.com.tokun.youled.service.ConsumoAPI;
import br.com.tokun.youled.service.ConverteDados;

@SpringBootApplication
public class YouledApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(YouledApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("First no web implementation. Uhuu!!!!");
		
		// String filme = "gilmore girls season 1";
		// String end = "https://www.omdbapi.com/?t="+ URLEncoder.encode(filme, StandardCharsets.UTF_8)
		String end = "https://www.omdbapi.com/?t=seinfeld&apikey=17240b54";
			
		var json = ConsumoAPI.obterDados(end);
		System.out.println(json);

		ConverteDados converte = new ConverteDados();
		DadosSerie serie = converte.obterDados(json, DadosSerie.class);
		System.out.println(serie);
	}

}
