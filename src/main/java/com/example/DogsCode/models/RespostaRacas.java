package com.example.DogsCode.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true) /*ignorar o restante que veio*/
public record RespostaRacas(Racas[] data) {
    @Override
    public String toString() {
        return "RespostaRacas{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
