import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public class Person implements Comparable<Person> {
        String name;
        double height;

        public Person(String name, double height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            if (o.height - this.height > 0) {
                return 1;
            } else if (o.height == this.height) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    private int N;
    private Person[] people;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            people = new Person[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                people[i] = new Person(st.nextToken(), Double.parseDouble(st.nextToken()));
            }

            Arrays.sort(people);

            sb.append(people[0].name).append(" ");
            for (int i = 1; i < N; i++) {
                if (people[0].height != people[i].height) {
                    break;
                }
                sb.append(people[i].name).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
