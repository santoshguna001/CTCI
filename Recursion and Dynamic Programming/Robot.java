import java.util.Stack;

class Robot {
    static class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Complexity is O(2^(r+c)) with path
    static Stack<Cell> solveTheGrid(int[][] grid, int current_x, int current_y, int end_x, int end_y,
            Stack<Cell> path) {

        if (current_x > end_x || current_y > end_y) {
            path.pop();
            return path;
        }
        if (current_x == end_x && current_y == end_y) {
            return path;
        }
        if (grid[current_x][current_y] == 0) {
            path.pop();
            return path;
        }
        path.add(new Cell(current_x + 1, current_y));
        path = solveTheGrid(grid, current_x + 1, current_y, end_x, end_y, path);
        Cell last = path.peek();
        if (last.x == end_x && last.y == end_y && grid[end_x][end_y] != 0) {
            return path;
        }
        path.add(new Cell(current_x, current_y + 1));
        path = solveTheGrid(grid, current_x, current_y + 1, end_x, end_y, path);
        return path;
    }

    // Complexity is O(rows*columns)
    static boolean solveTheGrids(int[][] grid, int current_x, int current_y, int end_x, int end_y) {

        if (current_x > end_x || current_y > end_y || grid[current_x][current_y] == 0) {
            return false;
        }
        if (current_x == end_x && current_y == end_y) {
            return true;
        }
        if (grid[current_x][current_y] == 2) {
            return false;
        }
        boolean move_down = solveTheGrids(grid, current_x + 1, current_y, end_x, end_y);
        boolean move_right = solveTheGrids(grid, current_x, current_y + 1, end_x, end_y);
        if (!move_down && !move_right) {
            grid[current_x][current_y] = 2;
        }
        return move_down || move_right;
    }

    // Complexity is O(2^(r+c))
    static boolean solveTheGridss(int[][] grid, int current_x, int current_y, int end_x, int end_y) {

        if (current_x > end_x || current_y > end_y || grid[current_x][current_y] == 0) {
            return false;
        }
        if (current_x == end_x && current_y == end_y) {
            return true;
        }
        boolean move_down = solveTheGridss(grid, current_x + 1, current_y, end_x, end_y);
        if (move_down) {
            return true;
        }
        boolean move_right = solveTheGridss(grid, current_x, current_y + 1, end_x, end_y);
        if (move_right) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 1, 0, 1, 1, 0 }, { 1, 0, 0, 1, 1 },
                { 1, 0, 0, 0, 1 } };
        int rows = grid.length;
        int columns = grid[0].length;
        Stack<Cell> path = new Stack<>();
        path.add(new Cell(0, 0));
        path = solveTheGrid(grid, 0, 0, rows - 1, columns - 1, path);

        Cell last = path.peek();
        if (last.x == rows - 1 && last.y == columns - 1 && grid[rows - 1][columns - 1] != 0) {
            System.out.println("Reached");
            path.forEach(S -> System.out.println("(" + S.x + "," + S.y + ")"));
        } else {
            System.out.println("Not reachable");
            path.forEach(S -> System.out.println("(" + S.x + "," + S.y + ")"));
        }

        System.out.println(solveTheGrids(grid, 0, 0, rows - 1, columns - 1));

    }
}