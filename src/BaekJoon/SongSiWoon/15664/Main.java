import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static int[] num;
    private static boolean[] visited;
    private static ArrayList<Integer> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];
        visited = new boolean[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        Arrays.fill(visited, false);
        res = new ArrayList<>();
        sol(0, 0, res);
    }

    public static void sol(int depth, int idx, ArrayList<Integer> lst) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(lst.get(i) + " ");
            }
            System.out.println();
            return;
        }
        int before = 0;
        for (int i = idx; i < N; i++) {
            if (!visited[i] && before != num[i]) {
                lst.add(num[i]);
                visited[i] = true;
                before = num[i];
                sol(depth + 1, i + 1, lst);
                lst.remove(lst.size() - 1);
                visited[i] = false;
            }
        }
    }
}
