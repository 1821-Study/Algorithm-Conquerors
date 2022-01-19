import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int K;
    private static int[] data;
    private static int[] term;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        data = new int[N];
        term = new int[N - 1];
        int sum = 0;

        for(int i = 0; i < N; i ++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);

        for(int i = 0; i < N - 1; i ++){
            term[i] = data[i + 1] - data[i];
        }

        Arrays.sort(term);

        for(int i = 0; i < N - K; i ++){
            sum += term[i];
        }
        System.out.println(sum);



    }
}
