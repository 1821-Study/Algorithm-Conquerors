import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int min = 0;

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(max<num) {
                max = num;
                for(int j = min+1; j<=max; j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                min = max;
            }

            if(stack.search(num) != -1){
                while(stack.size()>0 && stack.peek() >= num){
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }else if(stack.search(num) == -1){
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }

        }
        System.out.println(sb);
        br.close();
    }
}
