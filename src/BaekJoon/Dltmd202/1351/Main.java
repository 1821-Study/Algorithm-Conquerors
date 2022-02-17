import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static long N;
    static long P;
    static long Q;
    static Scanner sc = new Scanner(System.in);
    static Map<Long, Long> dp = new HashMap<>();
    public static void main(String[] args) {
        N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();

        dp.put(0L, 1L);
        dp.put(1L, 2L);
        System.out.println(getInfinitySequence(N));
    }

    public static long getInfinitySequence(long a){
        if(dp.containsKey(a)){
            return dp.get(a);
        }
        long left = getInfinitySequence(a / P);
        long right = getInfinitySequence(a / Q);
        dp.put(a, left + right);
        return dp.get(a);
    }
}
