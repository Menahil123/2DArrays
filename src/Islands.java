public class Islands {
    /* Directions arrays for the 8 possible moves (up, down, left, right, and
     4 diagonals)*/
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    // Method to check if a cell is safe to visit
    private static boolean isSafe(int[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < grid.length) &&
                (col >= 0) && (col < grid[0].length) &&
                (grid[row][col] == 1 && !visited[row][col]);
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];
            if (isSafe(grid, visited, newRow, newCol)) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
    // Method to count the number of islands
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        int numberOfIslands = countIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
    }
}
