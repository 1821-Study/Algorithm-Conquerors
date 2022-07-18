import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());		// 카드 장수 입력 받기
        LinkedList<Integer> card = new LinkedList<>();		// 카드 queue

        for(int i = 1; i<=N; i++){
            card.add(i);					// 카드 한 장씩 queue에 넣기
        }

        while(true){
            if(card.size() == 1){			// 카드가 1장 남았을 때에는
                System.out.println(card.poll());	// 해당 카드 출력
                break;
            }
            card.poll();			// 맨 위 카드 버리기
            card.add(card.poll());		// 그 다음 카드 맨 뒤로 보내기
        }

        br.close();
    }
}