package com.example.revisao_exercicios_lambda.strings;

import java.util.Scanner;

public class VerificaPalindromo {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite a palavra a ser verificada:");

        String palavra = leitura.nextLine();

        VerificaPalindromoInterface verificaPalindromo =
                palavra1 ->
            palavra1.equals(new StringBuilder(palavra)
                    .reverse()
                    .toString());
                    System.out.println(verificaPalindromo.verificaPalindromo(palavra));
                };
    }

