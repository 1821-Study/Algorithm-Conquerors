import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(st.nextToken());
            if(!map.containsKey(data)){
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int data = Integer.parseInt(st.nextToken());
            if(!map.containsKey(data))
                sb.append(0)
                        .append(" ");
            else {
                sb.append(map.get(data))
                        .append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
