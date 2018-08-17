/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question6;
import java.util.Scanner;
/**
 *
 * @author Santosh G
 */
public class Question6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String compressed_string=compress_string(input);
        if(compressed_string.length()<input.length()){
            System.out.println(compressed_string);
        }
        else{
            System.out.println(input);
        }
    }
    public static String compress_string(String input){
        String new_string="";
        int i, count = 1;
        char temp = input.charAt(0);
        new_string = new_string+temp;
        for(i=1;i<input.length();i++){
            char ch = input.charAt(i);
            if(ch==temp){
                count++;
            }
            else{
                if(count!=1){
                    new_string = new_string + Integer.toString(count);
                    count=1;
                }
                new_string = new_string + ch;
            }
            temp=ch;
        }
        if(count!=1){
            new_string = new_string + Integer.toString(count);
        }
        return new_string;
    }
}
