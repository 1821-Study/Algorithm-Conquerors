import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.*;

public class Main {
    static class Land {
        private int row;
        private int col;
        private int cnt;

        public Land(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Land(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Land> queue;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        NumberingMap();
        InitVisit();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && map[r][c] != 0) {
                    InitVisit();
                    MakeBridge(r, c, map[r][c]);
                }
            }
        }

        System.out.println(res);
    }

    public static void InitVisit() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }
    public static void MakeBridge(int r, int c, int num) {
        queue = new LinkedList<>();
        queue.add(new Land(r, c, 0));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            Land cur = queue.poll();
            int row = cur.row;
            int col = cur.col;
            int cnt = cur.cnt;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visited[nr][nc]) {
                        if (map[nr][nc] == 0) {
                            visited[nr][nc] = true;
                            queue.add(new Land(nr, nc, cnt + 1));
                        } else if (map[nr][nc] != 0 && map[nr][nc] != num) {
                            res = Math.min(res, cnt);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void NumberingMap() {
        queue = new LinkedList<>();
        int num = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c] || map[r][c] == 0) continue;
                map[r][c] = num;
                queue.add(new Land(r, c));
                visited[r][c] = true;
                while (!queue.isEmpty()) {
                    Land cur = queue.poll();
                    int row = cur.row;
                    int col = cur.col;
                    for (int i = 0; i < 4; i++) {
                        int nr = row + dr[i];
                        int nc = col + dc[i];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            if (!visited[nr][nc] && map[nr][nc] == 1) {
                                queue.add(new Land(nr, nc));
                                map[nr][nc] = num;
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
                num++;
            }
        }
    }
}
