import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int distance;
    private static int limit;
    private static Queue<Integer> trucks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        trucks = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sol());
    }

    public static int sol() {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < distance-1; i++){
            bridge.offer(0);
        }
        bridge.offer(trucks.peek());
        int total = trucks.poll();
        int res = 1;

        while (!bridge.isEmpty()){
            int front = bridge.poll();
            res++;
            total -= front;  // 트럭이 빠져 나가면 총 무게 빼주기
            if (!trucks.isEmpty()){
                if(total + trucks.peek() <= limit){  // 다음 트럭이 올라와도 되는 상황
                    int newtruck = trucks.poll();
                    bridge.offer(newtruck);
                    total += newtruck;
                } else bridge.offer(0);
            }
        }

        return res;
    }
}
