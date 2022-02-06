import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] num;
    private static boolean[] visited;
    private static int[] permutation;
    private static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N];
        permutation = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(sol(0));
    }

    public static int sol(int depth) {
        if (depth == N) {
            res = Math.max(res, sum());
            return res;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = num[i];
                sol(depth + 1);
                visited[i] = false;
            }
        }

        return res;
    }

    public static int sum() {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(permutation[i] - permutation[i + 1]);
        }
        return sum;
    }
}
