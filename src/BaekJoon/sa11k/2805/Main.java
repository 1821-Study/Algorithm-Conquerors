import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int max = Integer.MIN_VALUE;
        int min = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }


        long result = 0;
        while(min <= max){
            int mid = (min + max) / 2;
            result = 0;
            for(int i = 0; i<N; i++){
                if(tree[i] > mid){
                    result += (tree[i] - mid);
                }
            }

            if(M <= result) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(max);

        br.close();
    }
}



