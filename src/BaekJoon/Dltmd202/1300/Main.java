import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long left = 1, right = K;

        while(left < right){
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 1; i <= N; i ++){
                cnt += Math.min(mid / i, N);
            }
            if(K <= cnt){
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        System.out.println(left);
    }
}
