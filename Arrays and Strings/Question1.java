/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;
//Check if all characters are unique.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Santosh G
 */
public class Question1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        boolean[] array = new boolean[256];
        int i;
        for(i=0;i<input.length();i++){
            int ascii_value=input.charAt(i);
            //System.out.println(ascii_value);
            if(array[ascii_value]){
                System.out.println("Not Unique");
                break;
            }
            else{
                array[ascii_value]=true;
            }
            //System.out.println(array[ascii_value]);
        }
        if(i==input.length()){
            System.out.println("Unique");
        }
    }
}
