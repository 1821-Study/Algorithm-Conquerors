import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * 좌표 정렬하기2
 * https://www.acmicpc.net/problem/11651
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        String answer = Arrays.stream(coordinates)
                .sorted(Comparator.comparingInt(Coordinate::getY)
                        .thenComparing(
                                Comparator.comparing(Coordinate::getX)))
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        System.out.println(answer);
    }


    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y){
            this.y = y;
            this.x = x;
        }

        public int getY(){
            return y;
        }

        public int getX(){
            return x;
        }

        @Override
        public String toString(){
            return x + " " + y;
        }
    }
}
