/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question5;
import java.util.Scanner;
//Check if two strings will be equal when a character is deleted, modified or inserted in either of these
/**
 *
 * @author Santosh G
 */
public class Question5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input_1 = scanner.next();
        String input_2 = scanner.next();
        if(input_2.length()>input_1.length()){
            String temp = input_2;
            input_2 = input_1;
            input_1 = temp;
        }
        if(check_one_away(input_1, input_2)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    public static boolean check_one_away(String input_1, String input_2){
        int length_1 = input_1.length();
        int length_2 = input_2.length();
        input_1 = input_1.toLowerCase();
        input_2 = input_2.toLowerCase();
        int index_1, index_2, difference = 0;
        if(length_1-length_2 >= -1 && length_1-length_2 <= 1){
            for(index_1=0,index_2=0;index_1<length_1&&index_2<length_2;){
            if(input_1.charAt(index_1)==input_2.charAt(index_2)){
                index_1++;
                index_2++;
            }
            else if(input_1.charAt(index_1+1)==input_2.charAt(index_2)){
                index_1 = index_1 + 2;
                index_2++;
                difference++;
            }
            else{
               difference++;
               index_1++;
               index_2++;
            }
        }
        if(difference>1){
            return false;
        }
        return true;
        }
        else{
            return false;
        }
    }
}
