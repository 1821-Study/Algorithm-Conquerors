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
        System.out.println(sol(1L, (long) Math.pow(N,2)));
    }

    public static long sol(long start, long end) {
        while (start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                long tmp = Math.min(mid / i, N);
                if (tmp == 0) break;
                cnt += tmp;
            }
            if (cnt >= K) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
