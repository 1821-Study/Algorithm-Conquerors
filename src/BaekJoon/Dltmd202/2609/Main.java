import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int bsd = bsd(n, m);
        System.out.println(bsd);
        System.out.println(bsd * (n / bsd) * (m / bsd));
    }

    public static int bsd(int n, int m){
        int max = Math.max(n, m);
        int bsd = 1;
        for (int i = 1; i < max; i++) {
            if(n % i == 0 && m % i == 0) bsd = i;
        }
        return bsd;
    }
}
