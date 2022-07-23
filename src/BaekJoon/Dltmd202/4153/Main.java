import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true){
            Optional<int[]> input = getInput();
            if (input.isEmpty()) break;
            int[] data = input.get();
            if(isRightAngle(data)){
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean isRightAngle(int[] data) throws IOException {
        return data[2] * data[2] == data[0] * data[0] + data[1] * data[1];
    }

    public static Optional<int[]> getInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] data = new int[3];
        for (int i = 0; i < 3; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        if(data[0] == 0 && data[1] == 0 && data[2] == 0)
            return Optional.empty();
        else {
            Arrays.sort(data);
            return Optional.of(data);
        }
    }
}
