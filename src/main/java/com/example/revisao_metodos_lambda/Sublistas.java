package com.example.revisao_metodos_lambda;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*5 - Dada a lista de sublistas de números inteiros abaixo,
extraia todos os números primos em uma única lista
e os ordene em ordem crescente.*/
public class Sublistas {
    public static void main(String[] args) {
        List <List<Integer>> listaNumeros = Arrays.asList(
                Arrays.asList(-1,1,2,3,4),
                Arrays.asList(5,6,7,8),
                Arrays.asList(9,10,11,12)
        );

        System.out.println("Lista com sublistas: " + listaNumeros);

        List<Integer> lista = listaNumeros.stream()
                .flatMap(numero -> numero.stream())
                .collect(Collectors.toList());
        System.out.println("Lista sem sublistas: \n");
        lista.forEach(System.out::println);
        System.out.println("\n Numeros Primos: \n");
        Stream<Object> listaPrimos =  lista.stream()
                .map(numero -> {
                    if (numero < 0){
                        return false;
                    }
                    for (int i = 2; i < numero; i++){
                        int result = numero % i;
                        if (result == 0){
                            return false;
                        }
                    }
                    return numero;
                });
        listaPrimos.forEach(System.out::println);

    }
}
