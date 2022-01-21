import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    private static int N;
    private static int M;
    private static char[][] board;
    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        res = 65;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int tmp = CheckBoard(i, j);
                res = min(res, tmp);
            }
        }

        System.out.println(res);
    }

    public static int CheckBoard(int r, int c) {
        int wcnt = 0; // 시작이 W
        int bcnt = 0; // 시작이 B

        for (int i = r; i < r + 8; i++) {
            for (int j = c; j < c + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') wcnt += 1;
                    if (board[i][j] != 'B') bcnt += 1;
                }
                if ((i + j) % 2 != 0) {
                    if (board[i][j] != 'B') wcnt += 1;
                    if (board[i][j] != 'W') bcnt += 1;
                }
            }
        }

        return min(wcnt, bcnt);
    }
}
