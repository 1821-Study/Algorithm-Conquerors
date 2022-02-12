import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {-1, 1, 0, 0};
    static int[][] map;
    static int[] parents;
    static boolean[][] visited;
    static int answer;

    static class Node{
        int y;
        int x;
        int id;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
            id = M * y + x;
        }
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        parents = new int[N * M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i ++){
            int j = 0;
            for (char ch : br.readLine().toCharArray()) {
                switch (ch){
                    case 'U':
                        map[i][j++] = 0;
                        break;
                    case 'D':
                        map[i][j++] = 1;
                        break;
                    case 'L':
                        map[i][j++] = 2;
                        break;
                    case 'R':
                        map[i][j++] = 3;
                        break;
                }
            }
        }

        for(int i = 1; i < parents.length; i++){
            parents[i] = i;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        Set<Integer> vals = new HashSet<>();
        for(int i = 0; i < parents.length; i++){
            vals.add(findParent(parents, i));
        }
        System.out.println(vals.size());
    }

    public static void bfs(int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));


        while(!q.isEmpty()){
            Node now = q.poll();
            int direction = map[now.y][now.x];
            int ny = now.y + dy[direction];
            int nx = now.x + dx[direction];
            Node nNode = new Node(ny, nx);

            if(findParent(parents, now.id) != findParent(parents, nNode.id)){
                unionParent(parents, now.id, nNode.id);
                q.offer(nNode);
                visited[nNode.y][nNode.x] = true;
            }
        }
    }

    public static int findParent(int[] parents, int x){
        if(parents[x] != x){
            return findParent(parents, parents[x]);
        }
        return x;
    }

    public static void unionParent(int[] parents, int a, int b){
        int pa = findParent(parents, a);
        int pb = findParent(parents, b);

        if(pa > pb){
            parents[pa] = pb;
        } else {
            parents[pb] = pa;
        }
    }
}
