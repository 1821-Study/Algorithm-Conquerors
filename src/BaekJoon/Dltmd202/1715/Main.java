import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;


    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> q = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++){
            q.offer(Long.parseLong(br.readLine()));
        }

        while(q.size() > 1){
            long deck1 = q.poll();
            long deck2 = q.poll();
            answer += (deck1 + deck2);
            q.offer(deck1 + deck2);
        }
        System.out.println(answer);
    }
}
