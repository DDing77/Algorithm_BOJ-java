import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public class Person implements Comparable<Person> {
        int solve;
        int penalty;

        public Person(int solve, int penalty) {
            this.solve = solve;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Person o) {
            if (this.solve == o.solve) {
                return this.penalty - o.penalty;
            }
            return o.solve - this.solve;
        }
    }

    private int N;
    private Person[] people;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        if (N <= 5) {
            System.out.println(0);
            return;
        }

        people = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(people);

        res = 0;
        for (int i = 5; i < N; i++) {
            if (people[4].solve != people[i].solve) {
                break;
            }
            res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

