/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question8;
import java.util.Scanner;
//Set entire row and column as zeros if an element in a matrix is 0
/**
 *
 * @author Santosh G
 */
public class Question8 {
public static int[][] input;
public static int m, n;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        input=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                input[i][j]=scanner.nextInt();
            }
        }
        int i, j;
        zero_matrix();
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void zero_matrix(){
        int i, j, count;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(input[i][j]==0){
                    row[i]=true;
                    column[j]=true;
                }
            }
        }
        for(i=0;i<m;i++){
            if(row[i]){
                for(j=0;j<n;j++){
                    input[i][j]=0;
                }
            }
        }
        for(i=0;i<n;i++){
            if(column[i]){
                for(j=0;j<m;j++){
                    input[j][i]=0;
                }
            }
        }
    }
}
