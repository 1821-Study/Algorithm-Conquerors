import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        System.out.println(getConstructor(n));
    }

    private static int getConstructor(int n) {
        for (int i = 1; i <= n; i++) {
            int num = i, sum = i;
            while(num != 0){
                sum += (num % 10);
                num /= 10;
            }
            if(n == sum){
                return i;
            }
        }
        return 0;
    }
}
