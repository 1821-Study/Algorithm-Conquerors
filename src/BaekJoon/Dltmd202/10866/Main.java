import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 덱
 * https://www.acmicpc.net/problem/10866
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push_back")){
                deque.offerLast(Integer.parseInt(command.substring(10)));
            } else if(command.startsWith("push_front")){
                deque.offerFirst(Integer.parseInt(command.substring(11)));
            } else {
                if(command.equals("pop_front")){
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                } else if(command.equals("pop_back")){
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                } else if(command.equals("size")){
                    sb.append(deque.size());
                } else if(command.equals("empty")){
                    sb.append(deque.isEmpty() ? 1: 0);
                } else if(command.equals("front")){
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                } else if(command.equals("back")){
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
