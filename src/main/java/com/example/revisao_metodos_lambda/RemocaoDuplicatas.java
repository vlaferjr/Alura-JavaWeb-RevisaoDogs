package com.example.revisao_metodos_lambda;

import java.util.Arrays;
import java.util.List;

/*4 - Dada a lista de strings abaixo,
remova as duplicatas (palavras que aparecem mais de uma vez)
e imprima o resultado.*/
public class RemocaoDuplicatas {
    public static void main(String[] args) {
        List<String> listaPalavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        listaPalavras.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
