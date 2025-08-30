package com.example.revisao_metodos_lambda.idade_pessoa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*6 - Dado um objeto Pessoa com os campos nome e idade,
filtre as pessoas com mais de 18 anos,
extraia os nomes e imprima-os em ordem alfabética. */
public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Charlie", 19),
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17)
        );

        pessoas.stream()
                .filter(pessoa -> pessoa.idade >= 18)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);
    }

}
