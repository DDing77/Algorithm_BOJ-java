import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] A;
    private char[] B;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (A[i] != B[i]) {
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
