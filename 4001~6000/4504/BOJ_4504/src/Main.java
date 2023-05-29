import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String[] message = {" is NOT a multiple of ", " is a multiple of "};
    static int N;
    static int input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            sb.append(input);
            if (input % N == 0) {
                sb.append(message[1]).append(N);
            } else {
                sb.append(message[0]).append(N);
            }
            sb.append(".\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
