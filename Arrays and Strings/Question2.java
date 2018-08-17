/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;
import java.util.Scanner;
/**
 *
 * @author Santosh G
 */
public class Question2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input_1 = scanner.next();
        String input_2 = scanner.next();
        Question2 object = new Question2();
        if(object.permutation_check(input_1,input_2)){
            System.out.println("Permutation");
        }
        else{
            System.out.println("Not a permutation");
        }
    }
    public static boolean permutation_check(String input_1, String input_2){
        int[] array = new int[256];
        for(int i=0;i<input_1.length();i++){
            int ascii_value=input_1.charAt(i);
            array[ascii_value]++;
        }
        for(int i=0;i<input_2.length();i++){
            int ascii_value=input_2.charAt(i);
            if(array[ascii_value]!=0){
                array[ascii_value]--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
