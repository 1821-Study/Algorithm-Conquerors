import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();
        int count = 0;

        while(true){
            if(sugar % 5 == 0){
                count += sugar / 5;
                break;
            }
            else {
                sugar -= 3;
                count++;
            }
            if(sugar < 0){
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}