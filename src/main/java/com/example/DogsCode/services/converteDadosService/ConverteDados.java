package com.example.DogsCode.services.converteDadosService;

public interface ConverteDados {
    //pega os dados do json e converte em uma classe (passada por parâmetro)
    <T> T obterDados (String json, Class<T> classe);
}
