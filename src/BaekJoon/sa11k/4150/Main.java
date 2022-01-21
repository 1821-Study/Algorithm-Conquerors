import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void Fibo(BigInteger[] arr, int n){
        for(int i = 0; i<=n; i++){
            if(i <= 1){
                if(i <= 0){
                    arr[0] = BigInteger.valueOf(0);
                }
                arr[1] = BigInteger.valueOf(1);
            }else{
                for(int j = 2; j<=n; j++){
                    if(arr[j] == null){
                        arr[j] = arr[j-1].add(arr[j-2]);
                    } else{
                        continue;
                    }
                }
            }
        }
        System.out.println(arr[n]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger[] result_arr = new BigInteger[N+1];
        Fibo(result_arr, N);
    }
}
