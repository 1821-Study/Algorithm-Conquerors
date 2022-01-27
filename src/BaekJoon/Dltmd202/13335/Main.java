import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int W;
    private static int L;
    private static int[] weights;
    private static int[] entryTime;
    private static int totalWeight = 0;
    private static int currentTime = 0;
    private static Queue<Integer> q = new LinkedList<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        weights = new int[N];
        entryTime = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++){
            weights[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        while(i < N || !q.isEmpty()){
            currentTime += 1;
//            System.out.println(currentTime + " 초");
            if(!q.isEmpty() && entryTime[q.peek()] <= currentTime - W){
                Integer poll = q.poll();
                totalWeight -= weights[poll.intValue()];
//                System.out.println("차랑 밖으로 " + poll.intValue());
            }
            if(i < N && totalWeight + weights[i] <= L){
                q.offer(i);
                entryTime[i] = currentTime;
                totalWeight += weights[i];
//                System.out.println("차랑 진입 " + i);
                i++;
            }
        }
        System.out.println(currentTime);

    }

}
