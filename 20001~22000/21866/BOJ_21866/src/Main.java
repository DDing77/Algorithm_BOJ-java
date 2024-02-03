import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final HashMap<Integer, Integer> problemScore = new HashMap<>();
    int scoreSum;

    private void init() {

        problemScore.put(0, 100);
        problemScore.put(1, 100);
        problemScore.put(2, 200);
        problemScore.put(3, 200);
        problemScore.put(4, 300);
        problemScore.put(5, 300);
        problemScore.put(6, 400);
        problemScore.put(7, 400);
        problemScore.put(8, 500);
    }


    private void solution() throws IOException {

        scoreSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < problemScore.size(); i++) {
            int score = Integer.parseInt(st.nextToken());

            if (score > problemScore.get(i)) {
                System.out.println("hacker");
                return;
            }

            scoreSum += score;
        }

        if (scoreSum < 100) {
            System.out.println("none");
        } else {
            System.out.println("draw");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.init();
        main.solution();
    }
}
