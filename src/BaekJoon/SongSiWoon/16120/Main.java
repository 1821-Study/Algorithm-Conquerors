import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static String string;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        string = sc.next();
        boolean check = sol(string);
        if (check) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }

    public static boolean sol(String string) {
        Stack<Character> stack = new Stack<>();
        char[] str = string.toCharArray();
        int idx = 0;
        int len = string.length();
        while (idx < len - 1) {
            if (str[idx] == 'P') {
                stack.push(str[idx]);
            } else {
                if (str[idx + 1] != 'P') {
                    return false;
                }
                for (int i = 0; i < 2; i++) {
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != 'P') {
                        return false;
                    }
                }
            }
            idx++;
        }
        return (str[len - 1] == 'P' && stack.isEmpty());
    }
}
