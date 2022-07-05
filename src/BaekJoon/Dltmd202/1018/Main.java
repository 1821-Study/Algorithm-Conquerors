import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        char[] checker = {'W', 'B'};

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                res = Math.min(res, check(n, m, map, checker, 0, i, j));
                res = Math.min(res, check(n, m, map, checker, 1, i, j));
            }
        }
        System.out.println(res);
    }

    private static int check(int n, int m, char[][] map, char[] checker, int grad, int sy, int sx) {
        int modified = 0;
        int turn = grad;
        for (int i = sy; i < sy + 8; i++) {
            for (int j = sx; j < sx + 8; j++) {
                if (checker[turn % 2] != map[i][j]) {
                    modified++;
                }
                turn++;
            }
            turn++;
        }
        return modified;
    }
}
