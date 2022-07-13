import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i<=N; i++){
            if(checkPrime(i)){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean checkPrime(int num){
        if(num<=1) return false;
        else if(num==2) return true;
        else{
            for(int i = 2; i<=Math.sqrt(num); i++){
                if((num % i) == 0) return false;
            }
            return true;
        }
    }
}
