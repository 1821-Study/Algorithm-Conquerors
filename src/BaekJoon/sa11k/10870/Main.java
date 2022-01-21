import java.util.Scanner;

public class Main {
    public static int Fibo(int n){
        if(n<=1){
            if(n<=0){
                return 0;
            }
            return 1;
        }else{
            return Fibo(n-1)+Fibo(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Fibo(n));
    }
}
