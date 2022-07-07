import java.io.*;
import java.util.*;

class Main{
    static boolean[][] chess;
    static int result = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chess = new boolean[N][M];  // W : true, B : false

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<M; j++){
                if(s.charAt(j) == 'W'){
                    chess[i][j] = true;
                }else{
                    chess[i][j] = false;
                }
            }
        }

        checkchess();

        System.out.println(result);

        br.close();
    }

    static void checkchess(){
        for(int i = 0; i<=N-8; i++){
            for(int j = 0; j<=M-8; j++){
                W_comparechess(i, j);
                B_comparechess(i, j);
            }
        }
    }

    static void W_comparechess(int r, int c){
        boolean condition = true;
        boolean first = true;
        int count = 0;

        if(first != chess[r][c]) count++;

        for(int i = r; i<r+8; i++){
            if(i>r && first == chess[i][c]){
                count++;
                first = !chess[i][c];
                condition = !chess[i][c];
            }else if(i>r && first != chess[i][c]) {
                first = chess[i][c];
                condition = chess[i][c];
            }
            for(int j = c+1; j<c+8; j++){
                if(!condition == chess[i][j]){
                    condition = chess[i][j];
                }else{
                    count++;
                    condition = !chess[i][j];
                }
            }
        }

        if(count<result) result = count;
    }

    static void B_comparechess(int r, int c){
        boolean condition = false;
        boolean first = false;
        int count = 0;

        if(first != chess[r][c]) count++;

        for(int i = r; i<r+8; i++){
            if(i>r && first == chess[i][c]){
                count++;
                first = !chess[i][c];
                condition = !chess[i][c];
            }else if(i>r && first != chess[i][c]) {
                first = chess[i][c];
                condition = chess[i][c];
            }
            for(int j = c+1; j<c+8; j++){
                if(!condition == chess[i][j]){
                    condition = chess[i][j];
                }else{
                    count++;
                    condition = !chess[i][j];
                }
            }
        }

        if(count<result) result = count;
    }

}