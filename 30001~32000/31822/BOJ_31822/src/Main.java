import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String subject;
    private int N;
    private int res;

    private void solution() throws IOException {
        subject = br.readLine().substring(0, 5);

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String line = br.readLine().substring(0, 5);
            if (subject.equals(line)) {
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
