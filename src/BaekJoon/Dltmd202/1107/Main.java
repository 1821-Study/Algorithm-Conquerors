import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int N_LENGTH;
    private static int M;
    private static boolean[] broken = new boolean[10];
    private static Scanner sc = new Scanner(System.in);
    private static int answer = 0;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        N_LENGTH = Integer.toString(N).length();

        for(int i = 0; i < M; i ++){
            broken[sc.nextInt()] = true;
        }
        answer = Math.abs(N - 100);
        bruteForce(new ArrayList<>());
        System.out.println(answer);
    }

    public static void bruteForce(ArrayList<Character> keys){
        if(keys.size() < Math.min(7, N_LENGTH + 2)){
            if(keys.size() > 0) {
                int current = 0;
                for (int i = 0; i < keys.size(); i++) {
                    current += (int) keys.get(i) * Math.pow(10, i);
                }
                answer = Math.min(answer, Math.abs(N - current) + keys.size());
            }
            for(int i = 0; i < 10; i ++){
                if(!broken[i]){
                    keys.add((char) i);
                    bruteForce(keys);
                    keys.remove(keys.size() - 1);
                }
            }
        }
    }
}
