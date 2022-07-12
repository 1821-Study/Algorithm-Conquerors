import java.util.*;
import java.io.*;

public class Main {
    static int[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        input = new int[inputNum];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<inputNum; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int check = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i<check; i++){
            if(search(Integer.parseInt(st.nextToken())) >= 0)
                System.out.println(1);
            else
                System.out.println(0);
        }

        br.close();
    }

    public static int search(int num){
        int left = 0;
        int right = input.length-1;

        while(left<=right){
            int mid = (left+right) / 2;

            if(num < input[mid])
                right = mid - 1;

            else if(num > input[mid])
                left = mid + 1;

            else
                return mid;
        }

        return -1;
    }
}
