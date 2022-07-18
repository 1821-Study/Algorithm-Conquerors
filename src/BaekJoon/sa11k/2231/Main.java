import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());		// 자연수 입력
        int result = 0;						// 생성자를 저장할 변수


        for(int i = 1; i<N; i++){
            int num = i;		// 나머지, 나누기 연산을 하기 위해 값 복사
            int sum = 0;		// 분해합 구하기 위한 변수

            while(num != 0){
                sum += num % 10;	// 나머지 연산을 통해 각 자리를 더해줌
                num /= 10;		// 다음 자리를 더하기 위해 나누기 연산을 진행
            }

            if(sum + i == N){		// 위에서 계산한 값에 현재 값을 더해서 구한 분해합이 생성자인지 비교
                result = i;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }
}