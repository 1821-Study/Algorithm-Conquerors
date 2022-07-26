import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택
 * https://www.acmicpc.net/problem/10828
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")){
                int data = Integer.parseInt(command.substring(5));
                stack.push(data);
            } else {
                if (command.equals("top")) {
                    sb.append(!stack.isEmpty() ? stack.peek() : -1);
                } else if (command.equals("pop")){
                    sb.append(!stack.isEmpty() ? stack.pop() : -1);
                } else if(command.equals("size")){
                    sb.append(stack.size());
                } else if(command.equals("empty")){
                    sb.append(stack.isEmpty() ? 1: 0);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
