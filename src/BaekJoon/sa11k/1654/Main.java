import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lans = new int[K];

        long max = 0;
        long min = 1;
        long mid = 0;

        for(int i = 0; i<K; i++){
            lans[i] = Integer.parseInt(br.readLine());
            if(max < lans[i]){
                max = lans[i];
            }
        }

        while(max>=min){
            mid = (max + min) / 2;
            long count = 0;

            for(int i = 0; i<K; i++){
                count += lans[i] / mid;
            }

            if(count>=N){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        System.out.println(max);

        br.close();
    }
}
