import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static ArrayList<Integer> towers;
    private static Stack<Integer> res;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        towers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers.add(Integer.valueOf(st.nextToken()));
        }

        res = new Stack<>();
        sol();
        System.out.println(sb);
    }

    public static void sol() {
        for (int tower : towers) {
            if (res.isEmpty()) {
                res.push(tower);
                sb.append("0").append(" ");
            } else {
                while (true) {
                    if (res.isEmpty()) {
                        sb.append("0").append(" ");
                        res.push(tower);
                        break;
                    }
                    int before = res.peek();
                    if (before < tower) {
                        res.pop();
                    } else {
                        res.push(tower);
                        sb.append(towers.indexOf(before) + 1).append(" ");
                        break;
                    }
                }
            }
        }
    }
}
