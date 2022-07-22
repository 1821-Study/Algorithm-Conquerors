import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String triangle = br.readLine();
            StringTokenizer st = new StringTokenizer(triangle, " ");
            if(triangle.equals("0 0 0")) break;			// 0 0 0이 입력으로 들어올 때 종료
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 빗변이 C일 때
            if(Math.pow(C, 2) == Math.pow(A, 2) + Math.pow(B, 2)) System.out.println("right");
                // 빗변이 A일 때
            else if(Math.pow(A, 2) == Math.pow(B, 2) + Math.pow(C, 2)) System.out.println("right");
                // 빗변이 B일 때
            else if(Math.pow(B, 2) == Math.pow(A, 2) + Math.pow(C, 2)) System.out.println("right");
            else System.out.println("wrong");
        }

        br.close();
    }
}