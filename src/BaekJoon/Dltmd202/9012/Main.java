import java.io.*;
import java.util.*;

/**
 * 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            sb.append(checkValid())
                    .append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String checkValid() throws IOException {
        char[] data = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char d: data){
            if(d == '(') stack.push(d);
            else if(d == ')'){
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return "NO";
            }
        }

        return stack.isEmpty() ? "YES": "NO";
    }
}
