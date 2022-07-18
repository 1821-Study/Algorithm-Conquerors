import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;			// 통과해야 하는 벌집의 개수
        int last = 1;			// 위치할 수 있는 벌집의 주소 범위 중 가장 큰 값

        while(true){
            if(N == 1){			// 중앙에 위치한 1은 1개만 지남
                System.out.println(1);
                break;
            }
            else {					// 위치할 수 있는 벌집의 주소 범위 사이의 값을 계산
                if(N >= last + 1 && N <= last + count * 6){
                    System.out.println(count + 1);	// 해당 범위 내에 있다면 통과해야 하는 벌집 개수 출력
                    break;
                }
                last = last + count * 6;	// 위치할 수 있는 벌집의 주소 범위 중 가장 큰 값
                count++;			// 통과해야 하는 벌집의 개수 증가
            }
        }

        br.close();
    }
}