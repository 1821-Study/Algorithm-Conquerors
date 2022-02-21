import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};

    static class Node{
        int y;
        int x;
        int keySet;
        int keyCnt;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int keySet, int keyCnt) {
            this.y = y;
            this.x = x;
            this.keySet = keySet;
            this.keyCnt = keyCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            List<Node> entrance = new ArrayList<>();
            List<Node>[] waiting = new List[27];
            for(int i = 0; i < 27; i++){
                waiting[i] = new ArrayList<>();
            }
            int startingKeyCnt = 0;
            int startingKeySet = 0;

            for(int i = 0; i < h; i++){
                map[i] = br.readLine().toCharArray();
            }

            for(int i = 0; i < h; i++){
                if(map[i][0] != '*'){
                    entrance.add(new Node(i, 0));
                    if('a' <= map[i][0] && map[i][0] == 'z'){
                        entrance.add(new Node(i, 0));
                        startingKeySet = addKeySet(startingKeySet, map[i][0]);
                        startingKeyCnt++;
                    }
                }
                if(map[i][w - 1] != '*'){
                    entrance.add(new Node(i, w - 1));
                    if('a' <= map[i][w - 1] && map[i][w - 1] <= 'z'){
                        entrance.add(new Node(i, w - 1));
                        startingKeySet = addKeySet(startingKeySet, map[i][w - 1]);
                        startingKeyCnt++;
                    }
                }
            }

            for(int j = 1; j < w - 1; j++){
                if(map[0][j] != '*'){
                    entrance.add(new Node(0, j));
                    if('a' <= map[0][j] && map[0][j] <= 'z') {
                        startingKeySet = addKeySet(startingKeySet, map[0][j]);
                        startingKeyCnt++;
                    }
                }
                if(map[h - 1][j] != '*'){
                    entrance.add(new Node(h - 1, j));
                    if('a' <= map[h - 1][j] && map[h - 1][j] <= 'z'){
                        startingKeySet = addKeySet(startingKeySet, map[h - 1][j]);
                        startingKeyCnt++;
                    }
                }
            }

            char[] startingKey = br.readLine().toCharArray();
            if(startingKey[0] != '0') {
                startingKeyCnt = startingKey.length;
                startingKeySet = getStartingKeySet(startingKey, startingKeySet);
            }

            adaptEntranceKeySet(entrance, startingKeyCnt, startingKeySet);

            Queue<Node> q = new LinkedList<>();
            int secret = 0;
            boolean[][] visited = new boolean[h][w];

            for (Node node : entrance) {
                if('A' <= map[node.y][node.x] && map[node.y][node.x] <= 'Z'){
                    if(hasKey(startingKeySet, map[node.y][node.x])){
                        q.add(node);
                    } else {
                        waiting[ord(map[node.y][node.x])].add(node);
                    }
                } else if(map[node.y][node.x] == '$'){
                    q.add(node);
                    secret++;
                } else if(map[node.y][node.x] == '.'){
                    q.add(node);
                }
                visited[node.y][node.x] = true;

            }



            while (!q.isEmpty()){
                Node now = q.poll();

                for(int i = 0; i < 4; i++){
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if(0 <= ny && ny < h && 0 <= nx && nx < w && !visited[ny][nx]){
                        if(map[ny][nx] == '.'){

                            visited[ny][nx] = true;
                            q.add(new Node(ny, nx, now.keySet, now.keyCnt));

                        } else if('a' <= map[ny][nx] && map[ny][nx] <= 'z'){

                            for (Node waited : waiting[ord(map[ny][nx])]) {
                                waited.keySet = addKeySet(now.keySet, map[ny][nx]);
                                waited.keyCnt = now.keyCnt + 1;
                                q.add(waited);
                            }
                            waiting[ord(map[ny][nx])] = null;

                            Node nNode = new Node(ny, nx);
                            nNode.keySet = addKeySet(now.keySet, map[ny][nx]);
                            nNode.keyCnt = nNode.keyCnt + 1;
                            q.add(nNode);
                            visited[ny][nx] = true;

                        } else if('A' <= map[ny][nx] && map[ny][nx] <= 'Z'){

                            if(hasKey(now.keySet, map[ny][nx])){
                                visited[ny][nx] = true;
                                q.add(new Node(ny, nx, now.keySet, now.keyCnt));
                            } else {
                                waiting[ord(map[ny][nx])].add(new Node(ny, nx, now.keySet, now.keyCnt));
                                visited[ny][nx] = true;
                            }

                        } else if(map[ny][nx] == '$'){

                            visited[ny][nx] = true;
                            q.add(new Node(ny, nx, now.keySet, now.keyCnt));
                            secret++;

                        }
                    }
                }
            }
            sb.append(secret).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void adaptEntranceKeySet(List<Node> entrance, int startingKeyCnt, int startingKeySet) {
        for (Node node : entrance) {
            node.keyCnt = startingKeyCnt;
            node.keySet = startingKeySet;
        }
    }

    private static int getStartingKeySet(char[] startingKey, int startingKeySet) {
        for (char c : startingKey) {
            startingKeySet = addKeySet(startingKeySet, c);
        }
        return startingKeySet;
    }

    private static boolean hasKey(int keySet, char ch) {
        return (keySet & (1 << ord(ch))) != 0;
    }

    private static int addKeySet(int keySet, char c) {
        keySet |= (1 << ord(c));
        return keySet;
    }

    private static int ord(char c) {
        if('a' <= c && c <= 'z')
            return c - 'a';
        else
        return c - 'A';
    }
}
