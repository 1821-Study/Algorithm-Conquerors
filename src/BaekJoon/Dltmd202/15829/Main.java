import java.io.*;

/**
 * Hashing
 * https://www.acmicpc.net/problem/15829
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long MOD = 1234567891;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        char[] plain = br.readLine().toCharArray();
        long res = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {
            res += ((plain[i] - 'a' + 1) * pow);
            pow = (pow * 31) % MOD;
        }

        System.out.println(res % MOD);

    }
}
