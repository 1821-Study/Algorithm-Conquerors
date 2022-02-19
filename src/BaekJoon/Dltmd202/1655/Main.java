import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Comparator.comparingInt(o -> -o)));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int passed = 0;

        for(int i = 1; i <= N; i++){
            int data = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size())
                maxHeap.offer(data);
            else
                minHeap.offer(data);
            if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int swap = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(swap);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
