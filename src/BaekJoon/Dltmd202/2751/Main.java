import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(data);
        for (int i = 0; i < n; i++) {
            sb.append(data[i])
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}
