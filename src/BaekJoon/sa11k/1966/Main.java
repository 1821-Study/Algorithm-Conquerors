import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i<N; i++){
                queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            while(!queue.isEmpty()){
                int[] first = queue.pollFirst();
                boolean isMax = true;

                for(int i = 0; i<queue.size(); i++) {
                    if (first[1] < queue.get(i)[1]){
                        queue.add(first);
                        for(int j = 0; j<i ;j++){
                            queue.add(queue.pollFirst());
                        }
                        isMax = false;
                        break;
                    }
                }

                if(!isMax) continue;

                count++;
                if(first[0] == M){
                    sb.append(count).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}