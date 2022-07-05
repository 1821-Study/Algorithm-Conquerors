import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.y = y;
            this.x = x;
        }

        private int minDifference(Coordinate c){
            return Math.min(
                    Math.abs(this.x - c.x),
                    Math.abs(this.y - c.y)
            );
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Coordinate hansu = new Coordinate(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        Coordinate lowerLeft = new Coordinate(0 ,0);

        Coordinate upperRight = new Coordinate(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        int min = Integer.MAX_VALUE;

        min = Math.min(min, hansu.minDifference(lowerLeft));
        min = Math.min(min, hansu.minDifference(upperRight));

        System.out.println(min);
    }
}
