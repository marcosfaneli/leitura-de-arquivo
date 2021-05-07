/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unic.processador;

import br.com.unic.processador.services.LeitorDeArquivosService;

/**
 *
 * @author faneli
 */
public class Processador {
    
    public static void main(String[] args){
        LeitorDeArquivosService leitor = new LeitorDeArquivosService();
        leitor.obterListaDeArquivos();
    }
    
}
