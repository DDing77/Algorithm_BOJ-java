import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    String[] input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            input = br.readLine().split(" ");

            if (input[0].charAt(0) == '#') {
                break;
            }

            sb.append(input[0] + " ");
            if (Integer.parseInt(input[1]) > 17 || Integer.parseInt(input[2]) >= 80) {
                sb.append("Senior");
            } else {
                sb.append("Junior");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
