import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int K;
    private static int MOD = 1_000_000_000;
    private static int dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);

        for(int choice = 2; choice <= K; choice ++){
            for(int sum = 0; sum <= N; sum ++){
                int val = 0;
                for(int partSum = 0; partSum <= sum; partSum ++){
                     val = (val + dp[choice - 1][partSum]) % MOD;
                }
                dp[choice][sum] = (val % MOD);
            }
        }

        System.out.println(dp[K][N]);

    }
}
