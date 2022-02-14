import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        int length = data.length();
        int pivot = length / 2;

        check(data, length, pivot);
    }

    private static void check(String data, int length, int pivot) {
        if(data.length() == 1){
            System.out.println(1);
            return;
        }
        while (pivot <= length){
            String halfString = data.substring(0, pivot);
            String palindrome = halfString;

            StringBuffer sb = new StringBuffer(halfString);

            String leftHalfString = sb.reverse().toString();
            palindrome = halfString + leftHalfString.substring(1, leftHalfString.length());
            if(palindrome.length() >= length && palindrome.substring(0, length).equals(data)){
                System.out.println(palindrome.length());
                break;
            }

            sb = new StringBuffer(halfString);
            palindrome = halfString + sb.reverse().toString();
            if(palindrome.length() >= length && palindrome.substring(0, length).equals(data)){
                System.out.println(palindrome.length());
                break;
            }


            pivot++;
        }
    }


}