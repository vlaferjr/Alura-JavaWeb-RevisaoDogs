package com.example.revisao_exercicios_lambda.lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrdenacaoString {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite as palavras a serem ordenadas, quando quiser parar digite Fim");
        List<String> listaPalavras = new ArrayList<>();
        while (true){
            System.out.println("Digite a palavra:");
            String palavra = leitura.next();
            if (palavra.equalsIgnoreCase("Fim")){
                break;
            }
            listaPalavras.add(palavra);
        }
        System.out.println("Os resultados das palavras digitados foram: \n");
        listaPalavras.stream()
                .sorted()
                .forEach(System.out::println);

    }
}
