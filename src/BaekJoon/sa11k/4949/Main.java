import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();
            if(s.equals(".")) break;				// 입력받은 문자열이 종료조건이면 종료
            Stack<Character> stack = new Stack<>();		// 괄호를 담을 stack
            String result = "yes";

            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);				// 입력받은 문자열을 한글자씩 검색
                // 괄호라면
                if(c == '(' || c == ')' || c == '[' || c == ']'){
                    // stack이 비어있다면
                    if(stack.isEmpty()){
                        // 입력받은게 왼쪽 괄호가 아니라면 no 출력
                        if(c == ')' || c==']') {
                            result = "no";
                            break;
                        }
                        // 왼쪽 괄호라면 stack에 push()
                        stack.push(c);
                    }
                    // stack이 비어있지 않다면
                    else{
                        if(c == '(' || c == '[') stack.push(c);		// 왼쪽 괄호라면 push()
                        if(c == ')'){					// 오른쪽 소괄호라면
                            char before = stack.pop();			// 이전 것 pop()
                            if(before != '(') result = "no";		// pop()한 것이 소괄호가 아니라면 no 출력
                        }
                        else if(c == ']'){				// 오른쪽 대괄호라면
                            char before = stack.pop();			// 이전 것 pop()
                            if(before != '[') result = "no";		// pop()한 것이 대괄호가 아니라면 no 출력
                        }
                    }
                }
                // 글자라면
                else continue;		// 다음 글자
            }

            if(!stack.isEmpty()) result = "no";

            System.out.println(result);
        }

        br.close();
    }
}