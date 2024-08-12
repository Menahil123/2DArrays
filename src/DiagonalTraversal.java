import java.util.*;
import java.util.Arrays;
public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 9, 8 },
                { 7, 6, 5 },
                { 4, 3, 2 }
        };

        DiagonalTraversal(matrix);
    }
    public static void DiagonalTraversal(int [][] matrix){
        if (matrix==null || matrix.length==0){
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //Traverse from the first column
        for (int row=0; row<m; row++){
            printDiagonal(matrix, row,0);
        }
        //traverse fom the last row
        for (int col=1; col<n; col++){
            printDiagonal(matrix,m-1,col);
        }
    }
    public static void printDiagonal(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (row >= 0 && col < n) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
        System.out.println();
    }
}