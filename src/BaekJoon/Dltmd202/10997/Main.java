import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int width;
    private static int height;
    private static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        width = 3 + 4 * (N - 1);
        height = N == 1 ? 1: width;
        map = new char[height][width + 2];
        makeMap();
        printMap();
    }

    private static void printMap() {
        for(int i = 0; i < height; ++i){
            if(i == 1){
                System.out.println(map[1][0]);
                continue;
            }
            for(int j = 0; j < width - 2; ++j){
                System.out.print(map[i][j] == '*' ? "*": " ");
            }
            System.out.println();
        }
    }

    public static void makeMap(){
        int pivot = 0;
        for(int grid = 0; grid < N; ++grid){
            for(int j = pivot; j < width - pivot; j++){
                map[pivot][j] = '*';
            }
            for(int i = pivot; i < height - pivot; ++i){
                map[i][pivot] = '*';
            }
            pivot += 2;
            for(int j = width - pivot - 1; j >= pivot - 2; --j){
                map[height - pivot + 1][j] = '*';
            }
            for(int i = pivot; i < height - pivot + 2; ++i){
                map[i][width - pivot - 1] = '*';
            }
        }
    }
}
