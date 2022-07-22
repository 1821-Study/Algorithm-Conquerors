import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        System.out.println(search(n));
    }

    private static int search(int n) {
        for (int i = n / 5; i >= 0; i--) {
            int left = n - (i * 5);
            for (int j = left / 3; j >= 0; j--) {
                if(left - (j * 3) == 0) return i + j;
            }
        }
        return -1;
    }
}
