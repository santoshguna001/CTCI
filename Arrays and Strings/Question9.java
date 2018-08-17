/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question9;
import java.util.Scanner;
/**
 *
 * @author Santosh G
 */
public class Question9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input_1 = scanner.next();
        String input_2 = scanner.next();
        if(rotation(input_1.toCharArray(), input_2.toCharArray())){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    public static boolean rotation(char[] input_1, char[] input_2){
        if(input_1.length!=input_2.length){
            return false;
        }
        else{
            int length=input_1.length;
            int i=0, j=0;
            for(i=0;i<length;i++){
                if(new String(input_1).equals(new String(input_2))){
                    return true;
                }
                char temp=input_1[0];
                for(j=0;j<length-1;j++){
                    input_1[j]=input_1[j+1];
                }
                input_1[j]=temp;
            }
        }
        return false;
    }
}
