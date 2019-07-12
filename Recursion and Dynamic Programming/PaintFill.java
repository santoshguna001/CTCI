class PaintFill {
    static enum Color {
        RED, GREEN, BLUE;
    };

    static Color[][] paintFill(Color color, int row, int column, Color[][] screen) {
        if ((column < 0 || column >= screen[0].length) || (row < 0 || row >= screen.length)) {
            return screen;
        }
        if (screen[row][column] != color) {
            screen[row][column] = color;
            System.out.println("(" + row + "," + column + ") set to blue: " + screen[row][column]);
            screen = paintFill(color, row, column - 1, screen);
            screen = paintFill(color, row, column + 1, screen);
            screen = paintFill(color, row + 1, column, screen);
            screen = paintFill(color, row - 1, column, screen);
        }
        return screen;
    }

    public static void main(String args[]) {
        int rows = 4, columns = 3;

        Color color_red = Color.RED;
        Color color_blue = Color.BLUE;
        Color[][] screen = new Color[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                screen[i][j] = color_red;
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
        screen = paintFill(color_blue, 2, 2, screen);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}