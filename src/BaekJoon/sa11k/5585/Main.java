import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        int return_money = 1000-money;
        int num = 0;
        int[] coins = new int[] {500, 100, 50, 10, 5, 1};

        for(int coin : coins){
            num += return_money / coin;
            return_money = return_money % coin;
        }

        System.out.println(num);
    }
}
