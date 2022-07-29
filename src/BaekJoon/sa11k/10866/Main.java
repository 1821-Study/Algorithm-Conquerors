import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push_front")) queue.addFirst(Integer.parseInt(st.nextToken()));
            else if(command.equals("push_back")) queue.addLast(Integer.parseInt(st.nextToken()));
            else if(command.equals("pop_front")){
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.pollFirst()).append("\n");
            }
            else if(command.equals("pop_back")){
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.pollLast()).append("\n");
            }
            else if (command.equals("size")) sb.append(queue.size()).append("\n");
            else if (command.equals("empty")){
                if (queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(command.equals("front")){
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peekFirst()).append("\n");
            }
            else if(command.equals("back")){
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peekLast()).append("\n");
            }
        }

        System.out.println(sb);


        br.close();
    }
}