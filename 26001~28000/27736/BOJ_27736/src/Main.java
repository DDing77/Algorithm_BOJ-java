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

        votes = new int[3];

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            votes[Integer.parseInt(st.nextToken()) + 1]++;
        }

        if (votes[1] >= (N + 1) / 2) {
            System.out.println("INVALID");
        } else if (votes[2] > votes[0]) {
            System.out.println("APPROVED");
        } else {
            System.out.println("REJECTED");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
