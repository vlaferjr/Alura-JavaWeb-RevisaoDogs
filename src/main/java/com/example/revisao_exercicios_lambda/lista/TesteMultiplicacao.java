package com.example.revisao_exercicios_lambda.lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TesteMultiplicacao {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite números inteiros, quando quiser parar digite 0");

        List<Integer> listaNumeros = new ArrayList<>();

        while (true){
            System.out.println("Digite o número:");
            int num = leitura.nextInt();

            if (num == 0) {
                break;
            }
            listaNumeros.add(num);
        }
        System.out.println("Os resultados dos numeros digitados foram: \n");
        listaNumeros.replaceAll(numero -> numero * 3);
        listaNumeros.forEach(System.out::println);


        //System.out.println("O resultado é " + listaNumeros);
    }
}
