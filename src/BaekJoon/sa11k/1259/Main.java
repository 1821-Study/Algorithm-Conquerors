import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String num = br.readLine();
            if(Integer.parseInt(num) == 0) break;

            String reverseNum = "";

            for(int i = num.length()-1; i>=0; i--){
                reverseNum += num.charAt(i);
            }

            if(num.equals(reverseNum)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

        br.close();
    }
}