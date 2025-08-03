package com.example.revisao_exercicios_lambda;

import java.util.Scanner;

public class TesteOperacoesMatematicas {

    int a,b,c,d;

    @FunctionalInterface
    interface OperacoesMatematicas {
        int executar(int a, int b);
    }
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o índice para entrar na operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Multiplicação");

        int indice = leitura.nextInt();

        System.out.println("Digite o primeiro valor a ser somado: ");
        int a = leitura.nextInt();
        System.out.println("Digite o segundo valor a ser somado");
        int b = leitura.nextInt();

        switch (indice) {
            case 1:
                somar(a, b);
                break;
            case 2:
                multiplicar(a, b);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        leitura.close();
        };
    public static void somar(int a, int b){
        OperacoesMatematicas soma = (x, y) -> x+y;
        System.out.println("O resultado da soma é: " + soma.executar(a,b));
    }

    public static void multiplicar(int c, int d){
        OperacoesMatematicas multiplicar = (x,y) -> x*y;
        System.out.println("O resultado da multiplicação é: " + multiplicar.executar(c,d));
    }
}

