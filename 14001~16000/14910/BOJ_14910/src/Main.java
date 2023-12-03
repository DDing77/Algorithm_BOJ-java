import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cur = -1;
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (cur > next) {
                System.out.println("Bad");
                return;
            }
            cur = next;
        }

        System.out.println("Good");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
