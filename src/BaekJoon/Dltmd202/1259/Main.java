import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            char[] ary = String.valueOf(n).toCharArray();
            sb.append(getAnswer(ary)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String getAnswer(char[] ary) {
        int left = 0, right = ary.length - 1;

        while (left < right){
            if(ary[left++] != ary[right--]) return "no";
        }
        return "yes";
    }
}
