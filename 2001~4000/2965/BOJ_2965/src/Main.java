import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;
    static int left, right;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        left = b - a - 1;
        right = c - b - 1;

        System.out.println(Math.max(left, right));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
