import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[][] check = new int[4001][2];
        int sum = 0;
        int max = 0;

        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            if(nums[i] < 0) {
                check[Math.abs(nums[i])][0]++;
                if(max < check[Math.abs(nums[i])][0]) max = check[Math.abs(nums[i])][0];
            }
            else if(nums[i] >= 0) {
                check[nums[i]][1]++;
                if(max < check[nums[i]][1]) max = check[nums[i]][1];
            }
        }
        Arrays.sort(nums);



        sb.append(Math.round((double) sum / N)).append("\n");
        sb.append(nums[N/2]).append("\n");
        // 최빈값 출력
        int count = 0;
        int num = 0;
        for(int i = 4000; i>=0; i--){
            if(check[i][0] == max){
                num = -i;
                count++;
            }
            if(count >=2) break;
        }

        if(count<2){
            for(int i = 0; i<4001; i++){
                if(check[i][1] == max){
                    num = i;
                    count++;
                }
                if(count >=2) break;
            }
        }

        sb.append(num).append("\n");
        sb.append(nums[N-1]-nums[0]).append("\n");

        System.out.println(sb);
        br.close();
    }
}