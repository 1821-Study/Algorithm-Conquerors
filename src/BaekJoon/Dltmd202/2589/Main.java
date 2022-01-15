import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            char[] line = st.nextToken().toCharArray();
            for(int j = 0; j < M; j ++){
                map[i][j] = line[j] == 'L'? 1: 0;
            }
        }

        for(int i = 0; i < N; i ++){
            for(int j = 0; j < M; j ++){
                if(map[i][j] == 1) bfs(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int sy, int sx){
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < N; i ++) Arrays.fill(visited[i], false);

        q.offer(new Node(sy, sx, 0));
        visited[sy][sx] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0; i < 4; i ++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        Node newNode = new Node(ny, nx, now.dist + 1);
                        answer = Math.max(answer, newNode.dist);
                        q.offer(newNode);
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        int dist;

        public Node(int y, int x, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
