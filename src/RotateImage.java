import java.util.*;
public class RotateImage {
    public static void rotate (int [][]matrix){
        int n= matrix.length;
        for(int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int temp=matrix[i][j];
                matrix [i][j]= matrix [j][i];
                matrix [j][i]=temp;
            }
        }
        //Reverse the row
        for (int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
    public static void printmatrix(int[][]matrix){
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                System.out.println(matrix [i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int [][] matrix1={
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix1);
        printmatrix(matrix1);
        System.out.println();
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix2);
        printmatrix(matrix2);
        System.out.println();
    }
}