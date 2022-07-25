import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken()
            );
        }

        Arrays.stream(people)
                .sorted(
                        Comparator.comparingInt(Person::getAge)
                                .thenComparing(
                                        Comparator.comparingInt(Person::getId))
                )
                .forEach(sb::append);

        System.out.println(sb.toString().trim());
    }

    static class Person{
        static int seq = 0;
        int id;
        int age;
        String name;

        public Person(int age, String name) {
            this.id = seq++;
            this.age = age;
            this.name = name;
        }

        public int getAge(){
            return age;
        }

        public String getName(){
            return name;
        }

        public int getId(){
            return id;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
}
