package com.example.revisao_metodos_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*3 - Dada a lista de números inteiros abaixo,
filtre os números ímpares, multiplique cada um por 2
e colete os resultados em uma nova lista.*/
public class ImparesMultDois {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> numerosImpares = numeros.stream()
                .filter(numero -> numero %2 != 0)
                .map(numero -> numero * 2)
                .collect(Collectors.toList());
        System.out.println(numerosImpares);
    }
}
