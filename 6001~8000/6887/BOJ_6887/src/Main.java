import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private double N;

    private void solution() throws IOException {
        N = Double.parseDouble(br.readLine());

        int res = (int)Math.sqrt(N);
        System.out.println("The largest square has side length " + res + ".");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
