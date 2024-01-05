import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    int N;
    HashMap<String, Integer> answer = new HashMap<>();
    String[] submit;
    int total;
    int score;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer.put(st.nextToken(), i);
        }

        submit = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            submit[i] = st.nextToken();
        }

        total = N * (N - 1) / 2;
        score = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (answer.get(submit[i]) < answer.get(submit[j])) {
                    score++;
                }
            }
        }

        System.out.println(score + "/" + total);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
