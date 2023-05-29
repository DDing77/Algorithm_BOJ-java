import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private char[] input;
    private int cnt;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();
        cnt = 0;
        res = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                if (input[i] == '(') {
                    cnt++;
                } else {
                    res += cnt;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
