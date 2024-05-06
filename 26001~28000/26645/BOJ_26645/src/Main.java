import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N <= 205) {
            System.out.println(1);
        } else if (N <= 217) {
            System.out.println(2);
        } else if (N <= 228) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
