import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> q = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        while (q.size() > 1){
            idx = (idx + (k - 1)) % q.size();

            answer.add(q.remove(idx));
        }
        answer.add(q.remove(0));

        System.out.println(
                answer.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "<", ">"))
        );
    }
}
