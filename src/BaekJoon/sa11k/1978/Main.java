import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++){
            if(isPrime(Integer.parseInt(st.nextToken()))) count++;
        }

        System.out.println(count);

        br.close();
    }

    static boolean isPrime(int num){
        if(num <= 1) return false;
        else if(num == 2) return true;
        else{
            for(int i = 2; i<=Math.sqrt(num); i++){
                if(num % i == 0) return false;
            }
            return true;
        }
    }
}