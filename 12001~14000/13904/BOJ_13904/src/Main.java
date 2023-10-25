import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    int N;
    PriorityQueue<Assignment> assignments;
    int[] days;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int maxDay = 0;
        assignments = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            maxDay = Math.max(maxDay, day);
            assignments.add(new Assignment(day, score));
        }

        days = new int[maxDay + 1];
        while (!assignments.isEmpty()) {
            Assignment cur = assignments.poll();

            for (int i = cur.day; i >= 1; i--) {
                if (days[i] == 0) {
                    days[i] = cur.score;
                    res += cur.score;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Assignment implements Comparable<Assignment> {
        int day;
        int score;

        public Assignment(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            if (this.score == o.score) {
                return Integer.compare(this.day, o.day);
            }
            return Integer.compare(o.score, this.score);
        }
    }
}
