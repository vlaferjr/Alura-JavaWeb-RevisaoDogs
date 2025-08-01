package com.example.DogsCode.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true) /*ignorar o restante que veio*/
public record Racas(String id, @JsonAlias("type") String tipo, @JsonAlias("attributes") AtributosRaca atributosRaca) {
    @Override
    public String toString() {
        return "Racas{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", atributosRaca=" + atributosRaca +
                '}';
    }
}
