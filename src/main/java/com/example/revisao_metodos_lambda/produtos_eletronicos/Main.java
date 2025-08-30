package com.example.revisao_metodos_lambda.produtos_eletronicos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*7 - Você tem uma lista de objetos do tipo Produto,
onde cada produto possui os atributos nome (String), preco (double) e categoria (String).
Filtre todos os produtos da categoria "Eletrônicos" com preço menor que R$ 1000,
ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.*/
public class Main {
    public static void main(String[] args) {
        List<Produtos> produtos = Arrays.asList(
                new Produtos("Smartphone", 800.0, "Eletrônicos"),
                new Produtos("Notebook", 1500.0, "Eletrônicos"),
                new Produtos("Teclado", 200.0, "Eletrônicos"),
                new Produtos("Cadeira", 300.0, "Móveis"),
                new Produtos("Monitor", 900.0, "Eletrônicos"),
                new Produtos("Mesa", 700.0, "Móveis")
        );

        List<Produtos> produtosEletronicosBaratos = produtos.stream()
                .filter(produto -> produto.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .filter(produto -> produto.getPreco() < 1000)
                .limit(2)
                .sorted(Comparator.comparing(Produtos::getPreco))
                .collect(Collectors.toList());
        produtosEletronicosBaratos.forEach(System.out::println);
    }
}
