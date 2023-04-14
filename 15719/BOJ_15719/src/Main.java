import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int nSum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()) - 1;

        nSum = (1 + N) * (N / 2);
        if (N % 2 == 1) {
            nSum += (1 + N) / 2;
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            nSum -= Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.abs(nSum));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
