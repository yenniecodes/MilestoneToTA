/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OOP.UserManagement;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author trishameiatienza
 */
public class LogIn {
    private String username; //encapsulation. restricted access
    private String password;
    
   
    public void setusername(String user){
        username = user;
    }
    public void setpassword(char[] pw){
        password = new String(pw);
    }
    
    public boolean isAuthenticated() throws FileNotFoundException, IOException, CsvValidationException {
        String filename = "HR Users Credentials.csv";
        
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
    public static class EmployeeLogIn {
    private String username; //encapsulation. restricted access
    private String password;
    
   
    public void setusername(String user){
        username = user;
    }
    public void setpassword(char[] pw){
        password = new String(pw);
    }
    
    public boolean isAuthenticated() throws FileNotFoundException, IOException, CsvValidationException {
        String filename = "Users Credentials.csv";
        
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
    }}