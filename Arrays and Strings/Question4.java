/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question4;
import java.util.Scanner;
//Check if the string forms a palindrome on permutation
/**
 *
 * @author Santosh G
 */
public class Question4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(palindrome_check(input)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    public static boolean palindrome_check(String input){
        input=input.toLowerCase();
        int[] array = new int[26];
        int i;
        for(i=0;i<input.length();i++){
            int n=input.charAt(i);
            if(n<=122 && n>=97){
                array[n-96]++;
            }
        }
        
        int count_odd=0;
        for(i=0;i<26;i++){
            if(array[i]%2!=0){
                count_odd++;
            }
        }
        
        if(count_odd==1 || count_odd == 0){
            return true;
        }
        return false;
    }
}
