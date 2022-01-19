import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        String[] numbers = sc.nextLine().split(" ");
        int[] card = new int[numbers.length];

        for(int i = 0; i<numbers.length; i++){
            card[i] = Integer.parseInt(numbers[i]);
        }

        int max_sum = 0;

        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                for (int k = j+1; k<N; k++){
                    int card_sum = card[i] + card[j] + card[k];
                    if(max_sum<card_sum & card_sum <= M){
                        max_sum = card_sum;
                    }
                }
            }
        }
        System.out.println(max_sum);
        sc.close();
    }
}
