import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        int top = 1;
        for (int i = N - 1; i >= N - 3; i--) {
            top *= i;
        }

        System.out.println(top / 6);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
