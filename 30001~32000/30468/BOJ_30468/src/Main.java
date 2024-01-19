import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int avg;

    private void solution() throws IOException {
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        avg = Integer.parseInt(st.nextToken());

        if (avg * 4 <= sum) {
            System.out.println(0);
        } else {
            System.out.println(avg * 4 - sum);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
