import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Robot{
        private int row;
        private int col;
        private int direction;
        private int order;

        public Robot(int row, int col, int dir, int order) {
            this.row = row;
            this.col = col;
            this.direction = dir;
            this.order = order;
        }
    }

    private static int M;
    private static int N;
    private static int[][] map;
    private static int targetrow;
    private static int targetcol;
    private static int targetdir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int d = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(r, c, d, 0);

        st = new StringTokenizer(br.readLine());
        targetrow = Integer.parseInt(st.nextToken()) - 1;
        targetcol = Integer.parseInt(st.nextToken()) - 1;
        targetdir = Integer.parseInt(st.nextToken());

        System.out.println(bfs(robot));
    }

    public static int bfs(Robot robot) {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        Queue<Robot> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        queue.add(robot);
        int repeat = 0;
        while (!queue.isEmpty()) {
            Robot qrobot = queue.poll();
            int row = qrobot.row;
            int col = qrobot.col;
            int dir = qrobot.direction;
            int order = qrobot.order;
            map[row][col] = 1;
            if (row == targetrow && col == targetcol){
                res = Math.min(res, order + dircount(dir, targetdir));
                continue; // 목표 달성시 더 진행할 필요가 없음
            }
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 0) {
                        if (dir == i+1 && repeat <= 3){
                            repeat ++;
                            if (repeat == 0) {
                                Robot nrobot = new Robot(nr, nc, i+1, order+1);
                                queue.add(nrobot);
                            }else {
                                Robot nrobot = new Robot(nr, nc, i+1, order);
                                queue.add(nrobot);
                            }
                        } else {
                            repeat = 0;
                            int diff = dircount(dir, i+1);
                            Robot nrobot = new Robot(nr, nc, i+1, order+1+diff);
                            queue.add(nrobot);
                        }
                    }
                }
            }
        }
        return res;
    }
    // 방향 전환 시 명령 횟수
    public static int dircount(int dir, int ndir) {
        if (dir == 1 && ndir == 2){
            return 2;
        } else if (dir == 2 && ndir == 1){
            return 2;
        } else if (dir == 3 && ndir == 4){
            return 2;
        } else if (dir == 4 && ndir == 3) {
            return 2;
        } else if(dir == ndir){
            return 0;
        } else return 1;
    }
}
