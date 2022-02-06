import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int prime = 2;

        while(N!=1){
            if(N % prime == 0){
                sb.append(prime+"\n");
                N /= prime;
            }else{
                prime++;
            }
        }
        System.out.println(sb);
        sc.close();
    }
}


