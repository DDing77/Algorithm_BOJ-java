import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String plain;
    String key;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        plain = br.readLine();
        key = br.readLine();

        for (int i = 0; i < plain.length(); i++) {
            char curPlain = plain.charAt(i);

            if (curPlain == ' ') {
                sb.append(" ");
                continue;
            }

            int j = i % key.length();
            char curKey = key.charAt(j);

            if (curPlain - curKey <= 0) {
                sb.append((char) (26 + 96 - Math.abs(curPlain - curKey)));
            } else {
                sb.append((char) ((curPlain - curKey) + 96));
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
