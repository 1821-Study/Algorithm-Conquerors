import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       int[][] apt = new int[15][15];

       for(int i = 0; i<15; i++){
           apt[0][i] = i;
           apt[i][1] = 1;
       }

       for(int tc = 1; tc<=T; tc++){
           int k = Integer.parseInt(br.readLine());
           int n = Integer.parseInt(br.readLine());

           for(int i = 1; i<=k; i++){
               for(int j = 0; j<=n; j++){
                   if(j == 0) apt[i][j] = 1;
                   if(apt[i][j] == 0){
                       apt[i][j] = apt[i][j-1] + apt[i-1][j];
                   }
               }
           }

           System.out.println(apt[k][n]);

       }


       br.close();
    }
}

