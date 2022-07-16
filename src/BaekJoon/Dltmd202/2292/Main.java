import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int i = getAnswer(n);
        System.out.println(i);
    }

    private static int getAnswer(int n) {
        if(n == 1) return 1;
        int base = 1;
        int grad = 0;
        int i = 0;

        while (base + grad * 6 < n){
            grad += i;
            i++;
        }
        return i;
    }
}
