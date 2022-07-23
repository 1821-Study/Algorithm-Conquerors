import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            String result = "YES";

            for(int j = 0; j<s.length(); j++){
                char c = s.charAt(j);
                if(stack.isEmpty()){
                    if(c == ')') {
                        result = "NO";
                        break;
                    }
                    stack.push(c);
                }
                else{
                    if(c == '(') stack.push(c);
                    if(c == ')'){					// 오른쪽 소괄호라면
                        char before = stack.pop();			// 이전 것 pop()
                        if(before != '(') result = "NO";
                    }
                }
            }

            if(!stack.isEmpty()) result = "NO";

            System.out.println(result);
        }
        br.close();
    }
}