package com.example.revisao_metodos_lambda;

import java.util.Arrays;
import java.util.List;

/*Dada a lista de strings abaixo, converta todas para letras maiúsculas e imprima-as*/
public class LetrasMaiusculas {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(palavra -> palavra.toUpperCase())
                .forEach(System.out::println);
    }
}
