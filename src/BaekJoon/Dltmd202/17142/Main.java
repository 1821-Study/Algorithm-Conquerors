import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[][] map;
    static List<Virus> viruses;
    static int answer = Integer.MAX_VALUE;

    static class Virus{
        int y;
        int x;

        public Virus(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class ActiveVirus extends Virus {
        int cur;

        public ActiveVirus(int y, int x, int cur){
            super(y, x);
            this.cur = cur;
        }

        public ActiveVirus(Virus virus, int cur){
            super(virus.y, virus.x);
            this.cur = cur;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    viruses.add(new Virus(i, j));
                }
            }
        }

        searchOptimum(new ArrayList<>(), 0, M);
        System.out.println(answer >= Integer.MAX_VALUE ? -1: answer);
    }

    public static void searchOptimum(List<Virus> current, int idx, int m){
        if(current.size() == m){
            answer = Math.min(answer, bfs(current));
        } else {
            for(int i = idx; i < viruses.size(); i ++){
                current.add(viruses.get(i));
                searchOptimum(current, i + 1, m);
                current.remove(current.size() - 1);
            }
        }
    }

    public static int bfs(List<Virus> settingVirus){
        int[][] visited = new int[N][N];
        Queue<ActiveVirus> q = new LinkedList<>();
        Boolean sure = true;
        int res = 0;

        for(int i = 0; i < N; i ++){
            Arrays.fill(visited[i], -1);
        }

        for(Virus virus : settingVirus){
            visited[virus.y][virus.x] = 0;
            q.offer(new ActiveVirus(virus, 0));
        }

        while(!q.isEmpty()){
            ActiveVirus now = q.poll();

            for(int i = 0; i < 4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < N){
                    if(visited[ny][nx] == -1){
                        if(map[ny][nx] == 0) {
                            visited[ny][nx] = now.cur + 1;
                            q.offer(new ActiveVirus(ny, nx, now.cur + 1));
                            if(res >= now.cur + 1){
                                sure = true;
                                res = now.cur + 1;
                            }
                            res = Math.max(res, now.cur + 1);
                            sure = true;
                        } else if(map[ny][nx] == 2){
                            visited[ny][nx] = now.cur + 1;
                            q.offer(new ActiveVirus(ny, nx, now.cur + 1));
                            if(res > now.cur + 1){
                                sure = false;
                                res = now.cur + 1;
                            }
                        }
                    }
                }

            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (visited[i][j] == -1) {
                    if(map[i][j] == 0) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }

        return sure ? res: res - 1;
    }

}
