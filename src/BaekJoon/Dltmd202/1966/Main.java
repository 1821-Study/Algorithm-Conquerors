import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Print{
        int order;
        int weight;

        public Print(int order, int weight) {
            this.order = order;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getOrder() {
            return order;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] weight = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Print> q = new LinkedList<>();
            List<Integer> weightQ = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                q.offer(new Print(i, weight[i]));
                weightQ.add(weight[i]);
            }
            Collections.sort(weightQ, (a, b) -> b - a);
            int cursor = 0;

            int turn = 0;

            while(!q.isEmpty()){
                Print now = q.poll();
                if(now.getWeight() < weightQ.get(cursor)){
                    q.offer(now);
                } else {
                    cursor++;
                    turn++;
                    if(now.getOrder() == m) break;
                }
            }
            System.out.println(turn);
        }
    }
}
