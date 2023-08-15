import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int cnt = 1;
            res = 1;
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i - 1) != input.charAt(i)) {
                    cnt = 1;
                } else {
                    cnt++;
                    res = Math.max(res, cnt);
                }
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
