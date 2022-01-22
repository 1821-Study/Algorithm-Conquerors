import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int N;
    private static int K;
    private static Bag[] bags;
    private static int[] knapsack;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        bags = new Bag[N];
        knapsack = new int[K + 1];
        for(int i = 0; i < N; i ++){
            bags[i] = new Bag(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < N; i++) {
            for(int j = K; j >= 0; j --){
                if(bags[i].weight <= j) {
                    knapsack[j] = Math.max(knapsack[j],
                            knapsack[j - bags[i].weight] + bags[i].value);
                }
            }
        }
        System.out.println(knapsack[K]);
    }

    static class Bag{
        private int value;
        private int weight;

        public Bag(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }
}