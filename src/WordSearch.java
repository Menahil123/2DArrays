import java.util.*;
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (DFS(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean DFS(char[][] board, String word, boolean[][] visited, int row,
                        int col, int index) {
        // base-case: all characters are matched
        if (index == word.length()) {
            return true;
        }
        // check boundaries and other conditions
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        // mark the current cell as visited
        visited[row][col] = true;
        // Explore all possible directions (right, left, down, up)
        boolean found = DFS(board, word, visited, row + 1, col, index + 1) ||
                DFS(board, word, visited, row - 1, col, index + 1) ||
                DFS(board, word, visited, row, col + 1, index + 1) ||
                DFS(board, word, visited, row, col - 1, index + 1);
        // Backtrack: unmark the current cell as visited
        visited[row][col] = false;
        return found;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        WordSearch ws = new WordSearch();
        char[][] board1 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        System.out.println(ws.exist(board1, word1));
        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word2 = "BASE";
        System.out.println(ws.exist(board2, word2));

        char[][] board3 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word3 = "ABCB";
        System.out.println(ws.exist(board3, word3));
    }
}
