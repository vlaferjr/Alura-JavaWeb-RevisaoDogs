package com.example.revisao_metodos_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*1 - Dada a lista de números inteiros abaixo, filtre apenas os números pares e imprima-os*/
public class NumerosPares {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numeros.stream()
                .filter(numero -> numero %2 == 0)
                .forEach(System.out::println);
    }
}
