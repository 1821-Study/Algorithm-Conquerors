import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int[][] dp;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        StringTokenizer st;
        for (int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 1;
        for (int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                answer = Math.max(dfs(i, j), answer);
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int y, int x){
        if(dp[y][x] != -1){
            return dp[y][x];
        }
        dp[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < N){
                if(map[ny][nx] > map[y][x]){
                    dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
                }
            }
        }
        return dp[y][x];
    }
}
