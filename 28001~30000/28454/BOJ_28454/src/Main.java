import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int res;
    private void solution() throws IOException {
        LocalDate today = LocalDate.parse(br.readLine());

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            LocalDate date = LocalDate.parse(br.readLine());
            if (today.equals(date) || today.isBefore(date)) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}

