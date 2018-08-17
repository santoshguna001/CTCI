/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question7;
import java.util.Scanner;
//Rotate a matrix by 90 degree
/**
 *
 * @author Santosh G
 */
public class Question7 {
public static int[][] input;
public static int n;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int i, j;
        n = scanner.nextInt();
        input = new int[n][n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                input[i][j]=scanner.nextInt();
            }
        }
        rotate_matrix();
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotate_matrix(){
        int i, j, temp_1 = n-1, temp_2 = n;
        for(i=0;i<=n/2;i++){
            for(j=i;j<temp_2-1;j++){
                int t = input[i][j];
                input[i][j]=input[j][temp_1];
                input[j][temp_1]=input[temp_1][temp_1-j];
                input[temp_1][temp_1-j]=input[temp_1-j][i];
                input[temp_1-j][i]=t;
            }
            temp_1--;
            temp_2--;
        }
    }
}
