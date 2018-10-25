/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.t2OrgArq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 17111238
 */
public class LerArquivo {
    
    private static LerArquivo la = null;
    private File arquivo;
 
    private LerArquivo(){
        arquivo = null;
    }
    
    public static LerArquivo getInstance() {
        if (la == null) {
            la = new LerArquivo();
        }
        return la;
    }
    
    private void leitura() throws FileNotFoundException{
        try (Scanner sc = new Scanner(arquivo)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
            }
        }catch(Exception e){
            System.out.println("Erro");
        }
    }
    
    public void inicia(File arquivo) throws FileNotFoundException {
        this.arquivo = arquivo;
        this.leitura();
    }
}
