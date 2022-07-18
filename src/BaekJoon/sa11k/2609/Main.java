import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int A = Integer.parseInt(st.nextToken());
       int B = Integer.parseInt(st.nextToken());

       int gcd = getGCD(A, B);
       int lcm = (A * B) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int getGCD(int a, int b){
        if(a % b == 0){
            return b;
        }
        return getGCD(b, a % b);
    }
}

