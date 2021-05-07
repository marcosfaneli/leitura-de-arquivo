/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unic.processador.models;

/**
 *
 * @author faneli
 */
public class Cidade {
    
    private final String estado;
    private final String cidade;
    private final int populacao;
    
    public Cidade(String estado, String cidade, int populacao){
        this.estado = estado;
        this.cidade = cidade;
        this.populacao = populacao;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public int getPopulacao() {
        return populacao;
    }
    
    public static Cidade parse(String linha){
        String[] dados = linha.split(";");
        
        String estado = dados[3];
        String nome = dados[4];
        int populacao = Integer.parseInt(dados[6]);
        
        Cidade cidade = new Cidade(estado, nome, populacao);
        
        return cidade;
    }
}
