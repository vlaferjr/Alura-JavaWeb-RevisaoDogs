package com.example.DogsCode.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) /*ignorar o restante que veio*/
public record AtributosRaca(@JsonAlias("name") String nome,
                            @JsonAlias("description") String descricao,
                            @JsonAlias("life") VidaRaca vidaRaca) {
    @Override
    public String toString() {
        return "AtributosRaca{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", vidaRaca=" + vidaRaca +
                '}';
    }
}
