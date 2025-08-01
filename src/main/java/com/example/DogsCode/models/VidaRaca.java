package com.example.DogsCode.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) /*ignorar o restante que veio*/
public record VidaRaca(@JsonAlias ("max") int tempoMaximo,
                       @JsonAlias("min") int tempoMinimo) {
}
