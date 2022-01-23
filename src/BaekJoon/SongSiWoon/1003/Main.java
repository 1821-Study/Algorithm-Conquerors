import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] one;
    private static int[] zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        one = new int[41];
        zero = new int[41];

        one[0] = 0;
        one[1] = 1;
        zero[0] = 1;
        zero[1] = 0;
        for (int i = 2; i <= 40; i++) {
            one[i] = one[i - 1] + one[i - 2];
            zero[i] = zero[i - 1] + zero[i - 2];
        }
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(zero[num]).append(" ").append(one[num]).append("\n");
        }
        System.out.println(sb);
    }
}
