import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;

    public int getValue(int idx) {
        int res = 0;
        int m = 4;
        for (int i = 0; i < 3; i++) {
            res += (input.charAt(idx + i) - '0') * m;
            m /= 2;
        }

        return res;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        while (input.length() % 3 != 0) {
            input = "0" + input;
        }

        for (int i = 0; i < input.length(); i += 3) {
            sb.append(getValue(i));
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
