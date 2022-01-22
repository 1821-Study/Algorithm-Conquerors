import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    private static int N;
    private static int M;
    private static boolean[] broken;
    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        broken = new boolean[10];
        Arrays.fill(broken, false);

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                broken[tmp] = true;
            }
        }

        res = abs(N - 100); // +, - 만으로 이동
        for (int channel = 0; channel <= 1000000; channel++) {

            int cnt = ButtonCount(channel); // 채널입력이 가능: 자릿수, 불가능: -1
            if (cnt == -1) continue;
            cnt += abs(N - channel);
            res = min(res, cnt);
        }
        System.out.println(res);
    }

    public static int ButtonCount(int num) {
        int cnt = 0;

        if (num == 0) {
            if (broken[0]) return -1;
            return 1;
        }

        while (num > 0) {
            int btn = num % 10;
            if (broken[btn]) return -1;
            cnt += 1;
            num /= 10;
        }

        return cnt;
    }
}
