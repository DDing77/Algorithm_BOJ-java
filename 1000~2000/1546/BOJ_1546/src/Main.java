import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int[] score;
    double total;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        score = new int[N];
        M = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            M = Math.max(M, score[i]);
        }

        total = 0;
        for (int i : score) {
            total += (i * 100.0) / M;
        }

        System.out.println(total / N);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
