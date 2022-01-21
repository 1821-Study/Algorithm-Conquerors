import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    private static int N;
    private static int[] col;
    private static int res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];

        sol(0);
        System.out.println(res);
    }

    public static void sol(int depth) {
        if (depth == N) {
            res += 1;
            return;
        }
        for (int i = 0; i < N; i ++) {
            col[depth] = i;
            if (CheckConflict(depth)){
                sol(depth + 1);
            }
        }
    }

    public static boolean CheckConflict(int row){
        for (int i = 0; i < row; i++) {
            // 열 체크
            if (col[row] == col[i]) return false;
            // 대각선 체크
            if (abs(col[row] - col[i]) == (row - i)) return false;
        }
        return true;
    }
}
