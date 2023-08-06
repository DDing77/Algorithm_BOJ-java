import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    String pattern;
    String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        pattern = "^" + br.readLine().replaceAll("\\*", ".*") + "$";

        while (N-- > 0) {
            input = br.readLine();

            if (input.matches(pattern)) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
