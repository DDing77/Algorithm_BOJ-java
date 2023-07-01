import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long start;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = Long.parseLong(br.readLine());

        int cnt = 1;
        while (start != 1L) {
            cnt++;
            if (start % 2 == 0) {
                start /= 2;
            } else {
                start = start * 3 + 1;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
