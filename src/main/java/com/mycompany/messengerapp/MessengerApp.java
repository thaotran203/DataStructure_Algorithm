
package com.mycompany.messengerapp;

import implementations.Queue;
import implementations.Stack;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessengerApp {

    static Queue<Character> queueMessage = new Queue<>();
    static Stack<Character> stackMessage = new Stack<>();
    static String message = "";
    
    static JFrame f = new JFrame();

    private static String reverseString(String str){  
        String temp = "";
        char ch;
        
        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i); //extracts each character
            temp = ch + temp; //adds each character in front of the existing string
        }
        return temp; 
    }  
    
    public static void inputMessage() {
        // creates an object of Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your message: ");
        
        message = input.nextLine();

        System.out.println("My name is " + message);

        // closes the scanner
        input.close();
    }
    
    public static void transfer(String message) {
        char[] arr = message.toCharArray();
        
        try {
            if (arr.length == 0) {
                throw new IOException();
            }
            else if (arr.length > 250) {
                JOptionPane.showMessageDialog(f, "The message characters must be less than 250 characters!!! Please type again");
                throw new ArrayIndexOutOfBoundsException("The message characters must be less than 250 characters!!! Please type again");
            }
            else {
                for (char x : arr)
                {
                    queueMessage.offer(x);
                    System.out.println("Transferring message..." + x);
                }
                System.out.println(queueMessage);
            }
        }
        catch (IndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println(arrayIndexOutOfBoundsException.getMessage());
        } 
        catch (IOException exception){
            System.out.println("You haven't typed anything yet!!! Please retype");
            inputMessage();
        }
    }
    
    public static void process() {
        while (!queueMessage.isEmpty()) {
            stackMessage.push(queueMessage.poll());
        }
        System.out.println("Message has been sent successfully!");
        System.out.println(stackMessage);
    }
    
    public static String result(){
        String s = "";
        Stack copy_Stack = (Stack)stackMessage.clone();
        while (!copy_Stack.isEmpty()) {
            String temp = copy_Stack.pop().toString();
            s = s + temp;
        }
        return reverseString(s);
    }

    public static void clearStack() {
        stackMessage.clear();
    }
    public static void main(String[] args) {
        
        MessengerForm boxchat = new MessengerForm();
        boxchat.setVisible(true);
        boxchat.showMessage();

    }
}
