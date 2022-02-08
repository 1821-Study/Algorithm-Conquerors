import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] nums;
    private static int[] dp;
    private static int pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int cur = 1; cur < N; cur++) {
            dp[cur] = 1;
            for (pre = 0; pre < cur; pre++) {
                if (nums[cur] < nums[pre] && dp[cur] <= dp[pre]) {
                    dp[cur] = dp[pre] + 1;
                } else if (nums[cur] == nums[pre]) {
                    dp[cur] = dp[pre];
                }
            }
        }
        OptionalInt res = Arrays.stream(dp).max();
        System.out.println(res.getAsInt());
    }
}
