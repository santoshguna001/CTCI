class Paren {
    public static void getParen(int opened, int closed, StringBuilder string) {
        if (opened <= 0 && closed <= 0) {
            System.out.println(string);
            return;
        }
        if (closed >= opened) {
            if (opened > 0) {
                string.append('(');
                getParen(opened - 1, closed, string);
                string.setLength(string.length() - 1);
            }
            if (closed > 0) {
                string.append(')');
                getParen(opened, closed - 1, string);
                string.setLength(string.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        string.append("");
        int numberParenthesis = 5;
        getParen(numberParenthesis, numberParenthesis, string);
    }
}