import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        System.out.println(data[(N - 1) / 2]);
    }
}
