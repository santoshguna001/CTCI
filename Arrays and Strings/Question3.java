/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;
import java.util.Scanner;
//URLify a string with spaces
/**
 *
 * @author Santosh G
 */
public class Question3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i, count=0;
        for(i=0;i<input.length();i++){
            if(input.charAt(i)==32){
                count++;
            }
        }
        Question3 object = new Question3();
        System.out.println(object.urlify(input.toCharArray(),count));
    }
    public static char[] urlify(char[] input,int number_of_spaces){
        char[] array=new char[input.length+2*number_of_spaces];
        int i,j;
        for(i=input.length-1,j=array.length-1;i>=0;i--){
            if(input[i]==' '){
                array[j--]='0';
                array[j--]='2';
                array[j--]='%';
            }
            else{
                array[j--]=input[i];
            }
        }
        return array;
    }
}
