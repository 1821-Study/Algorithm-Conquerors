import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 666;

        while(count != check){
            String num = i+"";
            if(num.contains("666")){
                count++;
            }
            i++;
        }

        System.out.println(i-1);


        br.close();
    }
}