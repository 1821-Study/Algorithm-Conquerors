import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int direction = 0;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int dx[] = new int[]{1, 0, -1, 0};
    private static int dy[] = new int[]{0, 1, 0, -1};
    private static Robot startingRobot;
    private static Robot endRobot;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        startingRobot = new Robot(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                encodeInputDirection(Integer.parseInt(st.nextToken()))
        );
        st = new StringTokenizer(br.readLine());
        endRobot = new Robot(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                encodeInputDirection(Integer.parseInt(st.nextToken()))
        );

        System.out.println(startingRobot.searchWay(endRobot));

    }


    public static int encodeInputDirection(int direction){
        if(direction == 1){
            return 0;
        } else if(direction == 3){
            return 1;
        } else if(direction == 2){
            return 2;
        } else if(direction == 4){
            return 3;
        }
        return 3;
    }

    static class Robot {
        int y;
        int x;
        int direction;

        public Robot(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }

        public int searchWay(Robot endPoint) {
            Queue<Location> q = new LinkedList<>();
            Location endLocation = new Location(endPoint.y, endPoint.x, endPoint.direction);
            boolean[][][] visited = new boolean[N + 1][M + 1][4];
            visited[this.y][this.x][this.direction] = true;
            q.offer(new Location(this.y, this.x, this.direction, 0));

            while(!q.isEmpty()){
                Location now = q.poll();
                if(now.equals(endLocation)){
                    return now.cnt;
                }

                for(int i = 0; i < 5; i ++){
                    if(i < 2){
                        int nDirection = now.changeDirection(i);
                        if(!visited[now.y][now.x][nDirection]){
                            q.offer(new Location(now.y, now.x, nDirection, now.cnt + 1));
                            visited[now.y][now.x][nDirection] = true;
                        }
                    } else {
                        int ny = now.y + dy[now.direction] * (i - 1);
                        int nx = now.x + dx[now.direction] * (i - 1);
                        if(1 <= ny && ny <= N && 1 <= nx && nx <= M){
                            if(map[ny][nx] == 0){
                                if(!visited[ny][nx][now.direction]) {
                                    q.offer(new Location(ny, nx, now.direction, now.cnt + 1));
                                    visited[ny][nx][now.direction] = true;
                                }
                            } else break;
                        }
                    }
                }
            }
            return -1;
        }


        static class Location{
            int y;
            int x;
            int direction;
            int cnt;

            public Location(int y, int x, int direction, int cnt) {
                this.y = y;
                this.x = x;
                this.direction = direction;
                this.cnt = cnt;
            }
            public Location(int y, int x, int direction) {
                this.y = y;
                this.x = x;
                this.direction = direction;
            }

            public int changeDirection(int order){
                if(order == 0) return turnRight();
                else return turnLeft();
            }

            public int turnRight(){
                return (direction + 1) % 4;
            }
            public int turnLeft(){
                return (direction + 4 - 1) % 4;
            }

            @Override
            public boolean equals(Object obj) {
                Location location = (Location) obj;
                if(location.x != this.x) return false;
                if(location.y != this.y) return false;
                if(location.direction != this.direction) return false;
                return true;
            }
        }

    }


}
