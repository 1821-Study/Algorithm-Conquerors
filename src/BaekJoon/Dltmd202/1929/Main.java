import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minValue = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());

        boolean[] prime = makePrimeTable(maxValue);

        for (int i = minValue; i <= maxValue; i++) {
            if(prime[i])
                sb.append(i)
                        .append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static boolean[] makePrimeTable(int maxValue) {
        boolean[] prime = new boolean[maxValue + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(maxValue); i++) {
            for (int j = 2; j * i <= maxValue; j++) {
                prime[i * j] = false;
            }
        }
        return prime;
    }
}
