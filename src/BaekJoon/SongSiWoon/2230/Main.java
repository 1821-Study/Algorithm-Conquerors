import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[] num;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        sol();
        System.out.println(min);
    }

    private static void sol() {
        int left = 0;
        int right = 0;
        while (left != N && right != N) {
            if (Math.abs(num[right] - num[left]) < M) {
                right++;
            } else if (Math.abs(num[right] - num[left]) > M) {
                min = Math.min(min, Math.abs(num[left] - num[right]));
                left++;
            } else {
                min = M;
                return;
            }
        }
    }
}
