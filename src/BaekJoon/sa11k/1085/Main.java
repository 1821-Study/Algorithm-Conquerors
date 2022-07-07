import java.io.*;
import java.util.*;

class Main{
    static int x, y, w, h;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        escape(x, w-x, h-y, y);

        System.out.println(result);

        br.close();
    }

    static void escape(int left, int right, int up, int down){
        if(result>left) result = left;
        if(result>right) result = right;
        if(result>up) result = up;
        if(result>down) result = down;
    }
}