import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        private int edge;
        private int weight;

        public Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
    private static final int INF = Integer.MAX_VALUE ;
    private static int V;
    private static int E;
    private static int startV;
    private static List<Node>[] graph;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        dijkstra(startV);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node curnode = pq.poll();
            int cur = curnode.edge;
            if (visited[cur]) continue;
            visited[cur] = true;
            for (Node next : graph[cur]) {
                if (dist[next.edge] > dist[cur] + next.weight) {
                    dist[next.edge] = dist[cur] + next.weight;
                    pq.add(new Node(next.edge, dist[next.edge]));
                }
            }
        }
    }
}
