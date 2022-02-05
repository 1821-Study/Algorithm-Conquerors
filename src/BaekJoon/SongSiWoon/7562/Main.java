import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Knight {
        int row;
        int col;
        int cnt;

        public Knight(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    private static int T;
    private static Knight start;
    private static Knight end;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int start_row = Integer.parseInt(st.nextToken());
            int start_col = Integer.parseInt(st.nextToken());
            start = new Knight(start_row, start_col, 0);

            st = new StringTokenizer(br.readLine());
            int end_row = Integer.parseInt(st.nextToken());
            int end_col = Integer.parseInt(st.nextToken());
            end = new Knight(end_row, end_col, 0);
            int res = sol(n, start);
            System.out.println(res);
        }

    }

    public static int sol(int size, Knight knight) {
        boolean[][] map = new boolean[size][size];
        Queue<Knight> queue = new LinkedList<Knight>();
        map[knight.row][knight.col] = true;
        queue.add(knight);
        int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
        while (!queue.isEmpty()) {
            Knight qknigt = queue.poll();
            if (qknigt.row == end.row && qknigt.col == end.col) {
                return qknigt.cnt;
            }
            for (int i = 0; i < 8; i++) {
                int nr = qknigt.row + dr[i];
                int nc = qknigt.col + dc[i];
                if (nr >= 0 && nr < size && nc >= 0 && nc < size){
                    if (!map[nr][nc]) {
                        map[nr][nc] = true;
                        queue.add(new Knight(nr, nc, qknigt.cnt + 1));
                    }
                }
            }

        }
        return -1;
    }
}
