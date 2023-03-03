import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int A;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = 0;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            A += Math.abs(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        System.out.println(A * 2);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
