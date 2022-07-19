import java.io.*;
import java.util.*;

class Main_220719 {
    static int N, M, dif, result;
    static int[] card, black;
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       card = new int[N];
       black = new int[3];
       dif = Integer.MAX_VALUE;
       result = 0;

       st = new StringTokenizer(br.readLine(), " ");
       for(int i = 0; i<N; i++){
           card[i] = Integer.parseInt(st.nextToken());
       }

       com(0, 0);

        System.out.println(result);

       br.close();
    }

    static void com(int cnt, int start){
        if(cnt == 3){
            int sum = 0;
            for(int i = 0; i<3; i++){
                sum += black[i];
            }
            if(M-sum >= 0 && M-sum < dif){
                result = sum;
                dif = M-sum;
            }
            return;
        }

        for(int i = start; i<N; i++){
            black[cnt] = card[i];
            com(cnt+1, i+1);
        }
    }
}

