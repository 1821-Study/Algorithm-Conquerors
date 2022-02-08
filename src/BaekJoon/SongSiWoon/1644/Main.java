import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] primes;
    private static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        primes = new int[N];
        SearchPrimeNums(N);
        int res = sol(N);
        System.out.println(res);
    }

    private static int sol(int num) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (!(left == size || right == size)) {
            int sum = 0;
            if (left == right) {
                sum = primes[right];
            } else {
                for (int i = left; i <= right; i++) {
                    sum += primes[i];
                }
            }
            if (sum == num) {
                cnt++;
                left++;
                right++;
            } else if (sum < num) {
                right++;
            } else left++;
        }
        return cnt;
    }

    private static void SearchPrimeNums(int num) {
        if (num < 2) return;

        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                primes[size] = i;
                size++;
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
