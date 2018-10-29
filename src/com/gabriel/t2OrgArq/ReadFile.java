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
public class ReadFile {
    
    private static ReadFile rf = null;
    private File file;
 
    private ReadFile(){
        file = null;
    }
    
    public static ReadFile getInstance() {
        if (rf == null) {
            rf = new ReadFile();
        }
        return rf;
    }
    
    private void Read() throws FileNotFoundException{
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
            }
        }catch(Exception e){
            System.out.println("Erro");
        }
    }
    
    public void inicia(File file) throws FileNotFoundException {
        this.file = file;
        this.Read();
    }
}
