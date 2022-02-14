import java.util.Scanner;

public class Main {

    private static int N;
    private static int len;
    private static String string;
    private static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        len = sc.nextInt();
        string = sc.next();
        char[] str = string.toCharArray();
        int idx = 0;
        int pattern = 0;
        while (idx <= len - 3) {
            if (str[idx] == 'I' && str[idx + 1] == 'O' && str[idx + 2] == 'I') {
                pattern++;
                idx += 2;
                if (pattern == N) {
                    res++;
                    pattern--;
                }
            } else {
                idx++;
                pattern = 0;
            }
        }

        System.out.println(res);
    }
}
