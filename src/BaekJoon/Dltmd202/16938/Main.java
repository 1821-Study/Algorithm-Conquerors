import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int L;
    private static int R;
    private static int X;
    private static int[] problems;
    private static int answer = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        X = sc.nextInt();
        problems = new int[N];

        for(int i = 0; i < N; i ++){
            problems[i] = sc.nextInt();
        }
        Arrays.sort(problems);
        backTracking(new ProblemSet(), 0);
        System.out.println(answer);
    }

    public static void backTracking(ProblemSet problemSet, int idx){
        if(L <= problemSet.difficultySum){
            if(problemSet.get(problemSet.size() - 1) - problemSet.get(0) >= X){
                answer += 1;
            }
        }
        for(int i = idx; i < N; i ++){
            if(problemSet.difficultySum + problems[i] <= R) {
                problemSet.addProblem(problems[i]);
                backTracking(problemSet, i + 1);
                problemSet.popProblem();
            }
        }

    }

    static class ProblemSet{
        private List<Integer> problems = new ArrayList<>();
        public int difficultySum = 0;

        public int addProblem(int difficulty){
            difficultySum += difficulty;
            problems.add(difficulty);
            return difficultySum;
        }

        public void popProblem(){
            Integer poped = problems.remove(problems.size() - 1);
            difficultySum -= poped.intValue();
        }

        public int get(int idx){
            return problems.get(idx).intValue();
        }

        public int size(){
            return problems.size();
        }
    }
}

