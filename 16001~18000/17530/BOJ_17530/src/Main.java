import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] votes;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        votes = new int[N];
        for (int i = 0; i < N; i++) {
            votes[i] = Integer.parseInt(br.readLine());
        }

        int maxIdx = 0;
        int maxVote = -1;
        for (int i = 0; i < N; i++) {
            if (maxVote < votes[i]) {
                maxIdx = i;
                maxVote = votes[i];
            }
        }

        if (maxIdx != 0) {
            System.out.println("N");
        } else {
            System.out.println("S");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
