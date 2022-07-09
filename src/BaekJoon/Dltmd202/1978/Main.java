import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int maxValue = Integer.MIN_VALUE;
        int[] data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(data[i], maxValue);
        }

        boolean[] table = primeTable(maxValue);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += table[data[i]] ? 1: 0;
        }
        System.out.println(cnt);
    }

    public static boolean[] primeTable(int maxValue){
        boolean[] table = new boolean[maxValue + 1];
        int pivot = (int) Math.sqrt(maxValue) + 1;
        Arrays.fill(table, 2, table.length, true);

        for (int i = 2; i < pivot; i++) {
            for (int j = 2; i * j <= maxValue; j++) {
                table[i * j] = false;
            }
        }
        return table;
    }
}
