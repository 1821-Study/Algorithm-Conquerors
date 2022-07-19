import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apartment = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                apartment[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int l = 1; l <= j; l++) {
                        apartment[i][j] += apartment[i - 1][l];
                    }
                }
            }
            sb.append(apartment[k][n])
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}
