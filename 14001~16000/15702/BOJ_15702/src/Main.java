import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private class Person implements Comparable<Person> {
        int id;
        int score;

        public Person(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            if (this.score == o.score) {
                return this.id - o.id;
            }
            return o.score - this.score;
        }
    }

    private Person[] persons;
    private int N, M;
    private int[] scores;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        persons = new Person[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (st.nextToken().charAt(0) == 'O') {
                    sum += scores[j];
                }
            }
            persons[i] = new Person(id, sum);
        }

        Arrays.sort(persons);

        System.out.println(persons[0].id + " " + persons[0].score);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
