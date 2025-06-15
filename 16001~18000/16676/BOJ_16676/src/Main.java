import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        int i = 11;
        int j = 1;

        while (N >= i) {
            i = i * 10 + 1;
            j++;
        }

        System.out.println(j);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
