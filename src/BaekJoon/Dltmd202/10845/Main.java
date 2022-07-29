import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐
 * https://www.acmicpc.net/problem/10845
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")){
                q.offer(Integer.parseInt(command.substring(5)));
            } else {
                if(command.equals("pop")){
                    if(!q.isEmpty()) {
                        sb.append(q.poll());
                    } else {
                        sb.append(-1);
                    }
                } else if(command.equals("size")){
                    sb.append(q.size());
                } else if(command.equals("empty")){
                    sb.append(q.isEmpty() ? 1: 0);
                } else if(command.equals("front")){
                    if(!q.isEmpty()){
                        sb.append(q.peek());
                    } else {
                        sb.append(-1);
                    }
                } else if(command.equals("back")){
                    sb.append(q.stream().reduce((a, b) -> b).orElse(-1));
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
