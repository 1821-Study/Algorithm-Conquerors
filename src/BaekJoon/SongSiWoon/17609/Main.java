import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    private static int N;
    private static char[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            int ret = CheckPalindrome(string);
            System.out.println(ret);
        }
    }

    public static int CheckPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        str = new char[string.length()];
        str = string.toCharArray();
        while (left <= right) {
            if (str[left] == str[right]) {
                left++;
                right--;
            } else {
                if (CheckPseudo(left, right)) {
                    return 1;
                } else return 2;
            }
        }
        return 0;
    }

    public static boolean CheckPseudo(int left, int right) {
        boolean res = true;
        int l = left;
        int r = right;
        l++;
        while (l <= r) {
            if (str[l] == str[r]) {
                l++;
                r--;
            } else {
                res = false;
                break;
            }
        }
        if (res) {
            return true;
        }
        l = left;
        r = right;
        r--;
        res = true;
        while (l <= r) {
            if (str[l] == str[r]) {
                l++;
                r--;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }
}
