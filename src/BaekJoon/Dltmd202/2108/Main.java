import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        Map<Integer, Integer> counter = new HashMap<>();
        int mostFrequentCnt = 0;
        List<Integer> mostFrequentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
            if(!counter.containsKey(data[i])){
                counter.put(data[i], 1);
            } else {
                counter.put(data[i], counter.get(data[i]) + 1);
            }
            if(mostFrequentCnt < counter.get(data[i])){
                mostFrequentCnt = counter.get(data[i]);
                mostFrequentList = new ArrayList<>();
                mostFrequentList.add(data[i]);
            } else if(mostFrequentCnt == counter.get(data[i])){
                mostFrequentList.add(data[i]);
            }
        }

        Arrays.sort(data);
        mostFrequentList.sort((a, b) -> a - b);
        System.out.println(
                Math.round(
                        (double) Arrays.stream(data).sum() / data.length
                )
        );
        System.out.println(data[data.length / 2]);
        System.out.println(
                mostFrequentList.size() > 1 ?
                        mostFrequentList.get(1) : mostFrequentList.get(0)
        );
        System.out.println(data[data.length - 1] - data[0]);
    }
}
