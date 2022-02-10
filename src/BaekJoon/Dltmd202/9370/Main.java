import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Node{
        int depart;
        int arrive;
        int distance;

        public Node(int depart, int arrive, int distance) {
            this.depart = depart;
            this.arrive = arrive;
            this.distance = distance;
        }

        public Node(int arrive, int distance) {
            this.arrive = arrive;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            problemSetting();
        }
        System.out.println(sb.toString().trim());
    }

    public static void problemSetting() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] s2Distance;
        int[] g2Distance;
        int[] h2Distance;
        int[] candidate;
        List<Node>[] graph;
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        List<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        s2Distance = new int[n + 1];
        g2Distance = new int[n + 1];
        h2Distance = new int[n + 1];
        graph = new List[n + 1];
        candidate = new int[t];
        for(int i = 0; i < n + 1; i ++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(s2Distance, Integer.MAX_VALUE);
        Arrays.fill(g2Distance, Integer.MAX_VALUE);
        Arrays.fill(h2Distance, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[depart].add(new Node(depart, arrive, dist));
            graph[arrive].add(new Node(arrive, depart, dist));
        }

        for(int i = 0; i < t; i++){
            candidate[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(candidate);

        dijkstra(s2Distance, graph, q, s);
        dijkstra(g2Distance, graph, q, g);
        dijkstra(h2Distance, graph, q, h);

        for(int i = 0; i < t; i ++){
            int validation = candidate[i];

            if(s2Distance[validation] == s2Distance[h] + h2Distance[g] + g2Distance[validation]
                    || s2Distance[validation] == s2Distance[g] + g2Distance[h] + h2Distance[validation]){
                answer.add(validation);
            }
        }
        for (Integer ans : answer) {
            sb.append(ans).append(" ");
        }
        sb.append("\n");
    }

    private static void dijkstra(int[] distance, List<Node>[] graph, Queue<Node> q, int s) {
        distance[s] = 0;
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.distance > distance[now.arrive]) continue;

            for (Node will : graph[now.arrive]) {
                if(now.distance + will.distance < distance[will.arrive]){
                    distance[will.arrive] = now.distance + will.distance;
                    q.offer(new Node(will.arrive, distance[will.arrive]));
                }
            }
        }
    }
}