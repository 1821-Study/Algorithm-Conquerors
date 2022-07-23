import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 달팽이는 올라가고 싶다
 * https://www.acmicpc.net/problem/2869
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.println(getDayAfter(a, b, v));
    }

    private static int getDayAfter(int a, int b, int v) {
        int leftDistanceExceptLastDay = v - a;
        int leftDayNeed = (int) Math.ceil((double) leftDistanceExceptLastDay / (a - b));
        return leftDayNeed + 1;
    }
}
