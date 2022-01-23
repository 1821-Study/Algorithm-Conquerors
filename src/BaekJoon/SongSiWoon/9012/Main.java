import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int T;
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            if (CheckVPS(br.readLine())) {
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    public static boolean CheckVPS(String brackets) {
        stack = new Stack<Character>();

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);

            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else return false;

    }
}
