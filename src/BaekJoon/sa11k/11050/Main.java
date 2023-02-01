import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(fac(N)/(fac(N-K)*fac(K)));

        br.close();
    }

    public static int fac(int n){
        int f = 1;
        for(int i = 1; i<=n; i++){
            f*=i;
        }
        return f;
    }
}