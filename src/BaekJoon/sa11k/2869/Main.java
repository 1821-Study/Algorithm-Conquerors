import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int count = 0;
        int move = A - B;

        count = (V - A) / move;     // 마지막으로 올라갈 것 남겨두고 하루 움직일 수 있는 양만큼 움직이기
        if(count * move + A >= V) System.out.println(count + 1);    // 움직일 수 있는만큼 움직이고 한 번 더 올라갔을 때, 나무 높이에 도달 했다면 한 번 더 올라간 것만 카운팅 더 해줌
        else System.out.println(count + 2);     // 해당 높이에 도달하지 못했다면 한 번 더 움직여야 하므로 한 번 더 올라간 것 + 그 다음 내려왔다 또 올라간 것 카운팅 해줌

        br.close();
    }
}