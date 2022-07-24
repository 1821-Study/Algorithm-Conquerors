import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][N];
        int[] grades = new int[N];

        for(int i = 0; i<N; i++){
            grades[i] = 1;
        }

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N-1; i++){
            for(int j = i+1; j<N; j++){
                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) grades[i]++;
                else if(people[i][0] > people[j][0] && people[i][1] > people[j][1]) grades[j]++;
            }
        }

        for(int grade : grades){
            System.out.print(grade+" ");
        }

        br.close();
    }
}