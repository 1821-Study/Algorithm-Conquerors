import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 제로
 * https://www.acmicpc.net/problem/10773
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int data = Integer.parseInt(br.readLine());

            if(data == 0) stack.pop();
            else stack.push(data);
        }

        System.out.println(
                stack.stream()
                        .mapToInt(Integer::intValue).sum()
        );
    }
}
