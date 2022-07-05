import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

        Arrays.sort(strs,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if(o1.length() == o2.length())
                            return o1.compareTo(o2);
                        else {
                            return o1.length() - o2.length();
                        }
                    }
                });

        System.out.println(
                Arrays.stream(strs)
                        .filter(s -> {
                            if(!visited.contains(s)){
                                visited.add(s);
                                return true;
                            }
                            return false;
                        })
                        .map(String::valueOf)
                        .collect(Collectors.joining("\n"))
        );
    }
}
