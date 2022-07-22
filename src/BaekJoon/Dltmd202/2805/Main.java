import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] data = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = Arrays.stream(data).max().getAsInt();

        while (left <= right){
            long mid = (left + right) / 2;

            long cut = cut(data, mid);

            if(cut >= m){
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        System.out.println(right);
    }


    public static long cut(int[] data, long length){
        return Arrays.stream(data)
                .filter(t -> t > length)
                .mapToLong(t -> t - length)
                .sum();
    }
}
