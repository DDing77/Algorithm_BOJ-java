import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    List<Member> members;

    private void solution() throws IOException {

        members = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            members.add(new Member(i, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(members);

        System.out.println(members.get(0).getId());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Member implements Comparable<Member> {

        private int id;
        private int totalScore;
        private int submitNumber;
        private int lastUpload;

        public Member(int id, int totalScore, int submitNumber, int lastUpload) {

            this.id = id;
            this.totalScore = totalScore;
            this.submitNumber = submitNumber;
            this.lastUpload = lastUpload;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Member o) {

            if (this.totalScore == o.totalScore) {
                if (this.submitNumber == o.submitNumber) {
                    return Integer.compare(this.lastUpload, o.lastUpload);
                }
                return Integer.compare(this.submitNumber, o.submitNumber);
            }
            return Integer.compare(o.totalScore, this.totalScore);
        }
    }
}
