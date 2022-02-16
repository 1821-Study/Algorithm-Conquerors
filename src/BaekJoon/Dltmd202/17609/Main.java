import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] data;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        data = new String[N];
        answer = new int[N];

        for(int i = 0; i < N; i++){
            data[i] = br.readLine();
        }

        for(int i = 0; i < N; i++){
            sb.append(palindrome(data[i], 1, 0, data[i].length() - 1)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static int palindrome(String data, int chance, int left, int right){
        while(left < right){
            if(data.charAt(left) != data.charAt(right)){
                if(chance > 0){
                    if(palindrome(data, chance - 1, left + 1, right) == 0 ||
                            palindrome(data, chance - 1, left, right - 1) == 0){
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
            }

            left++;
            right--;
        }
        return 0;
    }
}
