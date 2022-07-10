import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cables =  new int[k];
        long left = 1L, right = 1L;

        for (int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, cables[i]);
        }
        right++;

        System.out.println(getCableLength(n, cables, left, right));

    }

    private static long getCableLength(int n, int[] cables, long left, long right) {
        int res = 0;
        while (left < right){
            long mid = (left + right) / 2;
            int cutCnt = cut(cables, mid);

            if(cutCnt < n){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static int cut(int[] cables, long length){
        int cnt = 0;
        for (int cable : cables) {
            cnt += (cable / length);
        }
        return cnt;
    }
}
