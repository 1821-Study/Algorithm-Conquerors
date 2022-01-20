import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final int BISHOP = 2;
    private static int N;
    private static int[][] map;
    private static final int[] dx = new int[]{1, 1, -1, -1};
    private static final int[] dy = new int[]{1, -1, 1, -1};
    private static int[] answer;
    private static int status = 0;
    private static ArrayList<Node[]> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        answer = new int[2];
        nodes = new ArrayList<>();
        nodes.add(new Node[N * N / 2 + 1]);
        nodes.add(new Node[N * N / 2 + 1]);

        int[] idx = new int[2];
        for(int i = 1; i <= N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)){
                    nodes.get(0)[idx[0]] = new Node(i, j);
                    idx[0] += 1;
                } else {
                    nodes.get(1)[idx[1]] = new Node(i, j);
                    idx[1] += 1;
                }
            }
        }
        makeMap(0, 0);
        status = 1;
        makeMap(0, 0);
        System.out.println(answer[0] + answer[1]);
    }

    public static void makeMap(int idx, int count){
        answer[status] = Math.max(answer[status], count);
        for(int i = idx; i < N * N / 2 + 1; i ++){
            Node now = nodes.get(status)[i];
            if (now == null) continue;
            if(map[now.y][now.x] == 1 && isPossible(now.y, now.x)){
                map[now.y][now.x] = BISHOP;
                makeMap(i + 1, count + 1);
                map[now.y][now.x] = 1;
            }
        }
    }

    public static boolean isPossible(int y, int x){
        for(int i = 0; i < 4; i ++){
            int internal = 1;
            while(true){
                int ny = y + dy[i] * internal;
                int nx = x + dx[i] * internal;
                if(1 <= nx && nx <= N && 1 <= ny && ny <= N){
                    if(map[ny][nx] == BISHOP) return false;
                } else break;
                internal ++;
            }
        }
        return true;
    }

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
