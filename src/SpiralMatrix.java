import java.util.*;
import java.util.Scanner;
public class SpiralMatrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        fillSpiralMatrix(matrix, n);

        System.out.println("Spiral Matrix:");
        printMatrix(matrix, n);
    }
    private static void fillSpiralMatrix(int[][] matrix, int n) {
        int value = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (value <= n * n) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;
            // Traverse downwards
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;
            // Traverse from right to left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = value++;
            }
            bottom--;
            // Traverse upwards
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = value++;
            }
            left++;
        }
    }
    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
