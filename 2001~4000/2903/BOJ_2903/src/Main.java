import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(((1 << N) | 1) * ((1 << N) | 1));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

