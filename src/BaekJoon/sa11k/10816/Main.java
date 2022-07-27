import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Map<Integer, Integer> numCard = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!numCard.containsKey(num)) numCard.put(num, 1);
            else numCard.put(num, numCard.get(num) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!numCard.containsKey(num)) sb.append(0).append(" ");
            else sb.append(numCard.get(num)).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}