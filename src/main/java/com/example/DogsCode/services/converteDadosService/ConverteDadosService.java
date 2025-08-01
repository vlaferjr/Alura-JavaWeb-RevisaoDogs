package com.example.DogsCode.services.converteDadosService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDadosService implements ConverteDados{

    private ObjectMapper mapper = new ObjectMapper(); /*usado para converter dados*/
    @Override //método herdado da interface
    public <T> T obterDados(String json, Class<T> classe) {
        /*tenta pegar os dados do json e converter em uma classe
        * caso contrário lança a exception*/
        try{
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
