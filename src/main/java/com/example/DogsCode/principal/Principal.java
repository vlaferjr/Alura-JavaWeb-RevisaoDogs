package com.example.DogsCode.principal;

import com.example.DogsCode.models.*;
import com.example.DogsCode.services.ConsumoApiService;
import com.example.DogsCode.services.converteDadosService.ConverteDadosService;

import java.io.ObjectStreamClass;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private ConsumoApiService consumoApiService = new ConsumoApiService();
    private ConverteDadosService converteDados = new ConverteDadosService();
    Scanner leitura = new Scanner(System.in);

    //Definindo o endereço
    private final String ENDERECO = "https://dogapi.dog/api/v2/breeds/";

    //----------------exibição do menu
    public void menu (){
        //recebendo a raça do usuário
        System.out.println("Digite o id da raça canina");
        var idRaca = leitura.nextLine();
        Optional.ofNullable(idRaca);

        /*-------------------------------OBTER OS DADOS ----------------------------------*/
        //chamando o obterdados
        var  json = this.consumoApiService.obterDados(ENDERECO + idRaca);

        /*--------------------------CONVERSÃO DE DADOS-------------------------------------*/

        // tenta deserializar como RespostaRacasComId primeiro
        try {
            RespostaRacasComId dadosComId = converteDados.obterDados(json, RespostaRacasComId.class);
            impressaoDados(dadosComId);

        } catch (Exception e1) {
            try {
                RespostaRacas dados = converteDados.obterDados(json, RespostaRacas.class);
                impressaoDados(dados);
                criarLista(dados);
            } catch (Exception e2) {
                System.out.println("Erro ao desserializar a resposta: " + e2.getMessage());
            }
        }
    }

    /*-------------------------------IMPRESSÃO DOS DADOS CONVERTIDOS*/

    // Sobrecarga do método impressaoDados
    public void impressaoDados(RespostaRacas dadosConvertidos) {
        System.out.println("------------- DADOS CONVERTIDOS ------------------");
        System.out.println(dadosConvertidos);

        //ordenação de raças com vida mais longa (pegando pelo tempo máximo de vida)

    }

    public void impressaoDados(RespostaRacasComId dadosConvertidos) {
        System.out.println("------------- DADOS COM ID CONVERTIDOS ------------------");
        System.out.println(dadosConvertidos);
    }

    /*---------------------------------- CRIAÇÃO DE LISTAS -----------------------------*/
    public void criarLista (RespostaRacas dados){
        System.out.println("----------------- LISTA ITERADA ----------------------");
        List<String> listaNomesRacas = Arrays.stream(dados.data())
                        .map(racas ->
                            racas.atributosRaca().nome()
                                    .toUpperCase())
                                    .collect(Collectors.toList());
        listaNomesRacas.forEach(System.out::println);

        //ordenação de raças com vida mais longa (pegando pelo tempo máximo de vida)
        System.out.println("----------------- LISTA ITERADA POR ORDEM DE LONGEVIDADE----------------------");
        Arrays.stream(dados.data())
                .map(dado -> dado.atributosRaca())//pega o atributo raça
                .sorted(Comparator.comparing((AtributosRaca raca) -> raca.vidaRaca().tempoMaximo()).reversed())
                .limit(3) //pega as 3 Vida Máxima em ordem decrescente
                .forEach(raca -> System.out.println("Raça: " + raca.nome() + "| Vida máxima: " + raca.vidaRaca().tempoMaximo()));
    };
}


