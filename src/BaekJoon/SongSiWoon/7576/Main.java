import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static String[][] box;
    private static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new String[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = st.nextToken();
                if (box[i][j].equals("1")){
                    String row = Integer.toString(i);
                    String col = Integer.toString(j);
                    String tmp = row + " " + col + " 0";
                    queue.add(tmp);
                }
            }
        }
        int res = sol();
        if (checkbox()){
            System.out.println(res);
        } else {
            System.out.println("-1");
        }
    }

    public static int sol() {
        int[] dr = {0, 0, 1, -1}; // 좌 우 하 상
        int[] dc = {-1, 1, 0, 0};
        int res = 0;

        while (!queue.isEmpty()){
            String qtmp[] = queue.poll().split(" ");
            int row = Integer.parseInt(qtmp[0]);
            int col = Integer.parseInt(qtmp[1]);
            int day = Integer.parseInt(qtmp[2]);
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < N && nc >=0 && nc < M){
                    if (box[nr][nc].equals("0")) {
                        box[nr][nc] = "1";
                        String r = Integer.toString(nr);
                        String c = Integer.toString(nc);
                        String d = Integer.toString(day+1);
                        String tmp = r + " " + c + " " + d;
                        queue.add(tmp);
                    }
                }
            }
            res = day;
        }
        return res;
    }
    public static boolean checkbox() {
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (box[i][j].equals("0")) return false;
            }
        }
        return true;
    }
}
