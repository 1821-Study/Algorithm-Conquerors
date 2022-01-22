import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int size = 0;

        int[] stack = new int[N];

        for(int i = 0; i<N; i++){
            switch(sc.next()){
                case "push":
                    int n = Integer.parseInt(sc.next());
                    stack[size] = n;
                    size++;
                    break;
                case "pop":
                    if (size>0){
                        sb.append(stack[size-1]).append('\n');
                        stack[size-1] = 0;
                        size--;
                    }else{
                        sb.append(-1).append('\n');
                    }
                    break;
                case "size":
                    sb.append(size).append('\n');
                    break;
                case "empty":
                    if(size == 0){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "top":
                    if(size == 0){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(stack[size-1]).append('\n');
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
        sc.close();
    }
}


