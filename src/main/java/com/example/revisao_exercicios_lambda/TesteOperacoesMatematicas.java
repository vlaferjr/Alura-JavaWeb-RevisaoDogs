package com.example.revisao_exercicios_lambda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TesteOperacoesMatematicas implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TesteOperacoesMatematicas.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.menu();
    }
    int a,b,c,d;
    Scanner leitura = new Scanner(System.in);


    @FunctionalInterface
    interface OperacoesMatematicas {
        int executar(int a, int b);
    }
    public void menu() {
        System.out.println("Digite o índice para entrar na operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Multiplicação");
        System.out.println("3 - Verificação Primo");

        int indice = this.leitura.nextInt();

        switch (indice) {
            case 1:
                somar();
                break;
            case 2:
                multiplicar();
                break;
            case 3:
                verificarPrimo();
        }
        leitura.close();
    };


    public void somar(){
        System.out.println("Digite o primeiro valor a ser somado: ");
        int a = this.leitura.nextInt();
        System.out.println("Digite o segundo valor a ser somado");
        int b = leitura.nextInt();

        OperacoesMatematicas soma = (x, y) -> x+y;
        System.out.println("O resultado da soma é: " + soma.executar(a,b));
    }

    public void multiplicar(){
        System.out.println("Digite o primeiro valor a ser multiplicado: ");
        int a = leitura.nextInt();
        System.out.println("Digite o segundo valor a ser multiplicado");
        int b= leitura.nextInt();

        OperacoesMatematicas multiplicar = (x,y) -> x*y;
        System.out.println("O resultado da multiplicação é: " + multiplicar.executar(a,b));
    }

    public void verificarPrimo(){
        System.out.println("Digite o primeiro valor a ser verificado: ");
        int a = leitura.nextInt();

        if (a <=1){
            System.out.println("é um número negativo /1 então a verificação de " + a + " é falsa");
        }
        //cria lista de divisores fazendo números do intervalo de 2 até a raiz de a
        List<Integer> listaDivisores = IntStream.rangeClosed(2, (int) Math.sqrt(a))
                //converte em stream para usar o collect
                .boxed()
                //filtra os números divisíveis por a com resto = 0
                .filter(i -> a % i == 0)
                //coleta numa nova lista
                .collect(Collectors.toList());
        // se a lista for vazia, verificação é falsa
        boolean isPrimo = listaDivisores.isEmpty();

        System.out.println("A verificação de " + a + "é " + isPrimo);
    }
}
