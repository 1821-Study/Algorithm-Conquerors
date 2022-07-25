import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덩치
 * https://www.acmicpc.net/problem/7568
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i] = new Person(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }


        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if(i != j && persons[i].isNotGreater(persons[j])) rank++;
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString());

    }

    static class Person{
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isNotGreater(Person person){
            return this.weight < person.weight && this.height < person.height;
        }

    }
}
