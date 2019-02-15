/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeitorTxtBean {
    
    
    public static void main(String[] args) {
        
        String linha = new String();
        String nomeArquivo = "C:\\Users\\PC_LENOVO\\Desktop\\arquivo.txt";
        File  arq = new File(nomeArquivo);
           
        if(arq.exists()){
                try{
                    FileReader leitorArquivo = new FileReader(nomeArquivo);
                    BufferedReader buffeDeArquivo = new BufferedReader(leitorArquivo);
                                while(true){
                                    linha = buffeDeArquivo.readLine();
                                            if(linha==null){
                                              break;  
                                            }
                                    System.out.println(linha);  
                                }
                    
                }catch(Exception ex){
                    
                }
            }
    }
    
    
    
}
