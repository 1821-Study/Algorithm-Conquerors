import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] stairs;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = stairs[1];
        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        System.out.println(Upstairs(N));
    }

    public static int Upstairs(int n) {
        if (n == 0) {
            return 0;
        } else {
            if (dp[n] == 0) {
                dp[n] = Math.max(Upstairs(n - 2), Upstairs(n - 3) + stairs[n - 1]) + stairs[n];
            }
            return dp[n];
        }
    }
}
