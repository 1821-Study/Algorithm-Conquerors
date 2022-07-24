import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) stack.push(num);
            else stack.pop();
        }

        int sum = 0;
        int size = stack.size();
        for(int i = 0; i<size; i++){
            sum += stack.pop();
        }

        System.out.println(sum);

        br.close();
    }
}