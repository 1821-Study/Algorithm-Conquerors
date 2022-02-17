import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] data;

    public static void main(String[] args) throws IOException {
        data = br.readLine().toCharArray();

        System.out.println(isPPAP() ? "PPAP": "NP");
    }

    private static boolean isPPAP() {
        List<Character> stack;
        stack = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            stack.add(data[i]);
            while (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 'P' &&
                        stack.get(stack.size() - 3) == 'P' &&
                        stack.get(stack.size() - 2) == 'A' &&
                        stack.get(stack.size() - 1) == 'P') {
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.add('P');
                } else break;
            }
        }
        if(stack.size() == 1 && stack.get(0) == 'P'){
            return true;
        }
        return false;
    }
}
