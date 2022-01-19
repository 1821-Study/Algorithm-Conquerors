import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numNmoney = sc.nextLine().split(" ");
        int num = Integer.parseInt(numNmoney[0]);
        int money = Integer.parseInt(numNmoney[1]);
        int[] coin = new int[num];

        int count = 0;

        for(int i=0; i<num; i++){
            coin[i] = sc.nextInt();
        }

        for(int i=num-1; i>=0; i--){
            count += money / coin[i];
            money = money % coin[i];
        }

        System.out.println(count);
    }
}
