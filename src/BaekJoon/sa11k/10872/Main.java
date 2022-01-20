import java.util.Scanner;

public class Main {
    public static int fac(int n){
        int result_num = 1;
        if(n<=1){
            return result_num *= 1;
        }else{
            return result_num = n * fac(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fac(n));
    }
}
