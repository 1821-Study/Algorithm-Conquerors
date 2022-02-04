import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        System.out.println(sol(1, (int) Math.pow(N,2)));
    }

    public static int sol(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                int tmp = Math.min(mid / i, N);
                if (tmp == 0) break;
                cnt += tmp;
            }
            if (cnt > K) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
