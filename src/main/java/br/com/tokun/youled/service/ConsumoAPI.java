package br.com.tokun.youled.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public static String obterDados(String endereco){
        
         // String end = "https://viacep.com.br/ws/"+ "01330010" + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = null;
        
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        } 

        String json = response.body();
        return json;
    }

/*
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        return gson.fromJson(json, Endereco.class);
  
*/


}
