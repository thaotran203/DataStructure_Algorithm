/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ACER
 */
public class msgController {
    
        public static int AddMessageToFile(String msg) throws IOException{
        
        if(msg == null || msg.isEmpty()){
            return -1;
        }
        
        try (
            FileWriter writer = new FileWriter("C:\\Users\\ACER\\Documents\\NetBeansProjects\\MessengerApp\\src\\main\\java\\data\\Message.txt", true);
        ) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(msg);
            bufferedWriter.newLine();

            bufferedWriter.close();
            return 1;
            
        } catch (IOException e) {
            return -999;
        }
    }
}
