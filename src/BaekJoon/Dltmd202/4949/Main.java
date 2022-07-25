import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true){
            char[] data = br.readLine().toCharArray();
            if (data.length == 1 && data[0] == '.') break;

            sb.append(validateString(data))
                    .append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String validateString(char[] data) {
        Stack<Character> stack = new Stack<>();

        for(char d : data){
            if(d == '(' || d == '['){
                stack.push(d);
            } else if(d == ')'){
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return "no";
            } else if(d == ']'){
                if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return "no";
            }
        }
        if(stack.isEmpty()) return "yes";
        return "no";
    }
}
