import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    String input;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        res = 0;
        int bonus = 0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'X') {
                bonus = 0;
                continue;
            }
            res += i + 1 + bonus;
            bonus++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
