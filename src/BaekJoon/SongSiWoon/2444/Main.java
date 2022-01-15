import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PrintStar(N);
    }

    public static void PrintStar(int n){
        for(int i = 1; i < n+1; i++){
            System.out.println(" ".repeat(n-i) + "*".repeat(i) + "*".repeat(i-1));
        }
        for (int i = n-1; i > 0; i--){
            System.out.println(" ".repeat(n-i) + "*".repeat(i) + "*".repeat(i-1));
        }
    }
}
