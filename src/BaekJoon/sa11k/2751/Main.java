import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       int N = Integer.parseInt(br.readLine());
       LinkedList<Integer> nums = new LinkedList<>();

       for(int i = 0; i<N; i++){
           nums.add(Integer.parseInt(br.readLine()));
       }

       Collections.sort(nums);

       for(int i = 0; i<N; i++){
           sb.append(nums.poll()).append("\n");
       }

        System.out.println(sb);
    }
}

