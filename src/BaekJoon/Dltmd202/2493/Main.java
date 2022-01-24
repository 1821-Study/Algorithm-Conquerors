import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Tower> stack = new Stack<>();
        N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            Tower tower = new Tower(i, height);

            while(!stack.isEmpty()){
                if(stack.peek().height >= height) {
                    sb.append(stack.peek().idx + 1).append(" ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(tower);
        }

        System.out.println(sb.toString().trim());
    }

    public static class Tower{
        private int idx;
        private int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
