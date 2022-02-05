import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int N;
    public static StringBuilder sb;
    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        backTracking("");
        System.out.println(sb.toString());
    }

    private static void backTracking(String now){
        if(now.length() == N){
            sb.append(now).append('\n');
            return;
        }

        for(int i = 0; i < 10; i ++){
            if(isPrime(Integer.parseInt(now + i))){
                backTracking(now + i);
            }
        }
    }

    private static boolean isPrime(int x){
        if(x <= 1) return false;
        int end = (int) Math.sqrt(x);
        for(int i = 2; i <= end; i ++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
