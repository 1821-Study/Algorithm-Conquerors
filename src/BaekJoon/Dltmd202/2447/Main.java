import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int step;
    private static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        step = 0;
        for(int i = 1; i < N; i *= 3) step ++;
        map = new char[N + 1][N + 1];
        makeMap(N, N, step);
        printMap();
    }

    public static void printMap(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i ++){
            for(int j = 1; j <= N; j ++){
                sb.append(map[i][j] == '*' ? "*": " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void makeMap(int y, int x, int step){
        if(step == 1){
            for(int i = y; i > y - 3; i --){
                map[i][x] = '*';
                map[i][x - 2] = '*';
            }
            for(int j = x; j > x - 3; j --){
                map[y][j] = '*';
                map[y - 2][j] = '*';
            }
            return;
        }
        int grid = (int) Math.pow(3, step - 1);
        for(int j = 0; j < 3; j ++){
            makeMap(y, x - grid * j, step - 1);
            makeMap(y - grid * 2, x - grid * j, step - 1);
        }
        makeMap(y - grid, x, step - 1);
        makeMap(y - grid, x - grid * 2, step - 1);
    }
}
