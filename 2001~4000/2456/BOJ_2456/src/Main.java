import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] voteCnt;
    Candidate[] candidates;

    private void solution() throws IOException {

        voteCnt = new int[3];
        candidates = new Candidate[3];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = new Candidate(i + 1, new int[4]);
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < candidates.length; j++) {
                candidates[j].scoreCnt[Integer.parseInt(st.nextToken())]++;
            }
        }

        Arrays.sort(candidates);

        if (candidates[0].scoreCnt[1] == candidates[1].scoreCnt[1] &&
                candidates[0].scoreCnt[2] == candidates[1].scoreCnt[2]) {
            sb.append(0).append(" ").append(candidates[0].totalScore());
        } else {
            sb.append(candidates[0].number).append(" ").append(candidates[0].totalScore());
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Candidate implements Comparable<Candidate> {
        int number;
        int[] scoreCnt;

        public Candidate(int number, int[] scoreCnt) {
            this.number = number;
            this.scoreCnt = scoreCnt;
        }

        public int totalScore() {

            int totalScore = 0;

            for (int i = 1; i < scoreCnt.length; i++) {
                totalScore += i * scoreCnt[i];
            }

            return totalScore;
        }

        @Override
        public int compareTo(Candidate o) {

            if (o.totalScore() == this.totalScore()) {
                if (o.scoreCnt[3] == this.scoreCnt[3]) {
                    if (o.scoreCnt[2] == this.scoreCnt[2]) {
                        return Integer.compare(o.scoreCnt[1], this.scoreCnt[1]);
                    }
                    return Integer.compare(o.scoreCnt[2], this.scoreCnt[2]);
                }
                return Integer.compare(o.scoreCnt[3], this.scoreCnt[3]);
            }

            return Integer.compare(o.totalScore(), this.totalScore());
        }
    }
}
