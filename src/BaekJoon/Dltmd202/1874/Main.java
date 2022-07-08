import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        make(n, data);
    }

    private static void make(int n, int[] data) {
        Stack<Integer> stack = new Stack<>();
        int cursor = 1;

        try {
            for (int i = 0; i < n; i++) {
                if (stack.isEmpty() || stack.peek() < data[i]) {
                    for (int j = cursor; j <= data[i]; j++) {
                        stack.push(j);
                        sb.append("+\n");
                    }
                    cursor = data[i] + 1;
                }
                while (!stack.isEmpty() && stack.peek() >= data[i]) {
                    if(stack.pop() > data[i]) throw new RuntimeException();
                    sb.append("-\n");
                }
            }
            System.out.println(sb.toString().trim());
        }catch (Exception e){
            System.out.println("NO");
        }
    }
}
