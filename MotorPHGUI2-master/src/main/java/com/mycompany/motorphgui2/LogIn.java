/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphgui2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Yennie
 */
public class LogIn {
    private String username;
    private String password;
    
    public void setusername(String user){
        username = user;
    }
    public void setpassword(char[] pw){
        password = new String(pw);
    }
    
    public boolean isAuthenticated() throws FileNotFoundException, IOException, CsvValidationException {
        String filename = "Credentials.csv";
        
        try(CSVReader csvreader = new CSVReader(new FileReader(filename))){
        String[] line;

            while((line=csvreader.readNext())!=null){
                if(line[0].equals(username)){
                    return line[1].equals(password);
                } 
            }
        }
        return false;
    }
    
}
