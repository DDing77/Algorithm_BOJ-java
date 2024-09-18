import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String H;
    private String N;
    private int res;

    private void solution() throws IOException {

        H = br.readLine();
        N = br.readLine();

        int hLength = H.length();
        int nLength = N.length();

        for (int i = 0; i < hLength - nLength + 1; i++) {
            if (N.equals(H.substring(i, i + nLength))) {
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
