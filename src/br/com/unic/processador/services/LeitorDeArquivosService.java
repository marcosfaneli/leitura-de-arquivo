package br.com.unic.processador.services;

import br.com.unic.processador.models.Cidade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeitorDeArquivosService {
    
    private final String caminho = "resources/";
    
    public void obterListaDeArquivos(){
        File pastaDeArquivos = new File(caminho);
        
        File[] listaDeArquivos = pastaDeArquivos.listFiles();
        
        System.out.println("Total de arquivos encontrados: "+ listaDeArquivos.length);
        
        for(File arquivo : listaDeArquivos){
            System.out.println("Nome do arquivo: " + arquivo.getName());
            lerDadosDoArquivo(caminho + arquivo.getName());
        }
        
    }
    
    private void lerDadosDoArquivo(String nomeArquivo){
        int totalPopulacao = 0;
        
        try{
            FileReader file = new FileReader(nomeArquivo);
            Scanner leitorDeLinhas = new Scanner(file);
            
            leitorDeLinhas.useDelimiter("\n");
            
            while(leitorDeLinhas.hasNext()){
                String linha = leitorDeLinhas.next();
                
                Cidade cidade = Cidade.parse(linha);
                
                System.out.println("Estado: " + cidade.getEstado() + "\nCidade: " + cidade.getCidade() + "\nPopulação: " + cidade.getPopulacao());
                
                int populacaDoMunicipio = cidade.getPopulacao();
                
                totalPopulacao += populacaDoMunicipio;
            }
        }catch(FileNotFoundException erro){
            System.out.println("Ocorreu um erro ao processar o arquivo: "+ nomeArquivo + "\nErro: "+erro.getMessage());
        }
        
        System.out.println("====================================================");
        System.out.println("População Total do Estado: " + totalPopulacao);
        System.out.println("====================================================");
    }
    
    
}
