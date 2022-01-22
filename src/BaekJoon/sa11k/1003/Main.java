import java.util.Scanner;

public class Main {

    public static void fibonacci(int[][] arr, int n) {
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        for (int j = 2; j <= n; j++) {
            arr[j][0] = arr[j-1][0] + arr[j-2][0];
            arr[j][1] = arr[j-1][1] + arr[j-2][1];
        }
        System.out.println(arr[n][0] + " " + arr[n][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            int[][] zero_one_num = new int[k+2][2];
            fibonacci(zero_one_num, k);
        }
    }
}
