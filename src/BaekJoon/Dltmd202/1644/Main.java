import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static Scanner sc = new Scanner(System.in);
    static boolean[] primeTable;
    static List<Integer> prime = new ArrayList<>();
    static List<Integer> prefixPrime = new ArrayList<>();

    public static void main(String[] args) {
        N = sc.nextInt();
        primeTable = new boolean[N + 1];
        setPrimeNumberSet();
        int sum = 0;
        prefixPrime.add(sum);
        for(int i = 2; i <= N; i++){
            if(primeTable[i]) {
                sum += i;
                prime.add(i);
                prefixPrime.add(sum);
            }
        }
        System.out.println(searchSum());
    }

    public static void setPrimeNumberSet(){
        for(int i = 2; i <= N; i ++) primeTable[i] = true;

        for(int i = 2; i * i <= N; i ++){
            if(primeTable[i]){
                for(int j = i * i; j <= N; j += i){
                    primeTable[j] = false;
                }
            }
        }
    }

    public static int searchSum(){
        int right = 1;
        int answer = 0;
        if(N == 1){
            return 0;
        }

        for(int left = 0; left < prefixPrime.size(); left++){
            while(true){
                int sum = prefixPrime.get(right) - prefixPrime.get(left);
                if(sum == N){
                    answer ++;
                    if(right < prefixPrime.size() - 1){
                        right ++;
                    }
                    break;
                } else if(sum < N && right < prefixPrime.size() - 1){
                    right++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
