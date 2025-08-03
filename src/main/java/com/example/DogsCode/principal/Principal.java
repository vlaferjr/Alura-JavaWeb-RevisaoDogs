package com.example.DogsCode.principal;

import com.example.DogsCode.models.AtributosRaca;
import com.example.DogsCode.models.Racas;
import com.example.DogsCode.models.RespostaRacas;
import com.example.DogsCode.models.RespostaRacasComId;
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
    };

}


