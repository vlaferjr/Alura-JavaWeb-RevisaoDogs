package com.example.revisao_exercicios_lambda.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConverteStrings {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite a palavra a ser convertida:");

        String palavra = leitura.nextLine();

        ConverteStringsInterface converteMaiuscula =
                p -> p.toUpperCase();
            System.out.println(converteMaiuscula.converter(palavra));
        }
    }
