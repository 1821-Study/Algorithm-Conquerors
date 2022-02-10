import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Virus {
        private int row;
        private int col;
        private int time;

        public Virus(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean[] selected;
    private static List<Virus> viruslst;
    private static Queue<Virus> queue;
    private static int blank = 0;
    private static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        viruslst = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if (tmp == 2) {
                    viruslst.add(new Virus(i, j, 0));
                } else if (tmp == 0) {
                    blank++;
                }
            }
        }

        selected = new boolean[viruslst.size()];
        VirusCombi(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(res);

    }

    public static void VirusCombi(int depth, int index) {
        if (depth == M) {
            int tmp = BFS();
            res = Math.min(tmp, res);
        }

        for (int i = index; i < viruslst.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                VirusCombi(depth + 1, i + 1);
                selected[i] = false;
            }
        }
    }

    public static int BFS(){
        queue = new LinkedList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < viruslst.size(); i++) {
            if (selected[i]) {
                queue.add(viruslst.get(i));
                visited[viruslst.get(i).row][viruslst.get(i).col] = true;
            }
        }
        int ans = 0;
        int cnt = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Virus qvirus = queue.poll();
            int qrow = qvirus.row;
            int qcol = qvirus.col;
            int qtime = qvirus.time;
            if (cnt == blank) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = qrow + dr[i];
                int nc = qcol + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visited[nr][nc] && map[nr][nc] != 1){
                        if (map[nr][nc] == 0) {
                            cnt++;
                            ans = qtime + 1;
                        }
                        visited[nr][nc] = true;
                        queue.add(new Virus(nr, nc, qtime + 1));
                    }
                }
            }
        }
        if (cnt == blank) {
            return ans;
        } else return Integer.MAX_VALUE;
    }
}
