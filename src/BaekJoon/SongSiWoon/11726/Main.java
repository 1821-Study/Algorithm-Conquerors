import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static int N;
    private static BigInteger[] DP;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DP = new BigInteger[1001];
        DP[0] = new BigInteger("1");
        DP[1] = new BigInteger("1");
        DP[2] = new BigInteger("2");
        for (int i = 3; i <= N; i++) {
            DP[i] = DP[i - 1].add(DP[i - 2]);
        }
        System.out.println(DP[N].mod(BigInteger.valueOf(10007)));
    }
}
