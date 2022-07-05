import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int turn = Integer.parseInt(br.readLine());
        long n = 666;

        int cnt = 0;
        while (true){
            char[] numArray = String.valueOf(n).toCharArray();
            if(isValid(numArray)) cnt++;
            if(cnt == turn) break;
            n++;
        }
        System.out.println(n);
    }

    private static boolean isValid(char[] numArray) {
        for (int i = 0; i <= numArray.length - 3; i++) {
            if(numArray[i] == '6' && numArray[i + 1] == '6' && numArray[i + 2] == '6'){
                return true;
            }
        }
        return false;
    }
}
