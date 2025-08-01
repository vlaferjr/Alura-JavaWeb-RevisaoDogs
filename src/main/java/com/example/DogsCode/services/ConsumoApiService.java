package com.example.DogsCode.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApiService {

    public String obterDados (String url){
        //cliente para fazer a requisição
        HttpClient cliente = HttpClient.newHttpClient();

        //requisição feita pelo cliente
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        //resposta http null
        HttpResponse <String>resposta = null;
        try {
            //recebendo a resposta da requisição no body
            resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e){
            throw new RuntimeException();
        } catch (InterruptedException e){
            throw new RuntimeException();
        }
        //peganod a resposta
        String json = resposta.body();
        //retornando a reposta no json
        return json;
    }
}
