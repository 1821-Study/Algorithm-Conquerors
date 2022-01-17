import java.util.Scanner;

public class Main {
    private static int n;
    private static int width;
    private static int height;
    private static char[][] stars;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        width = n;
        height = n;
        stars = new char[height][width];

        sol(n, 0, 0);
        PrintStars(stars);
    }

    public static void sol(int size, int row, int col){
        if(size == 3){
            for(int i = 0; i < 3; i++){
                stars[row][col + i] = '*';
                stars[row + 2][col + i] = '*';
            }
            stars[row + 1][col] = '*';
            stars[row + 1][col + 2] = '*';
            return;
        }
        int next = (int) size / 3;
        for (int i = 0; i < 3; i++){
            sol(next, row, col + (i*next));
            sol(next, row + (next * 2), col + (i * next));
        }
        sol(next, row + next, col);
        sol(next, row + next, col + (2 * next));
    }

    public static void PrintStars(char[][] stars){
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (stars[r][c] == '*') {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
