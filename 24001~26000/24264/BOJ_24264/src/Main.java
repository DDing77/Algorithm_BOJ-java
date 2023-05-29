import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long n;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());

        System.out.println((n * n) + "\n" + "2");
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
