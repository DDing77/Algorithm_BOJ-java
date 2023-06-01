import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int tc;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            if (N % 2 == 0) {
                N = (((N * 3) / 2) * 3) / 9;
                sb.append(tc++ + ". even " + N);
            } else {
                N = ((((N * 3) + 1) / 2) * 3) / 9;
                sb.append(tc++ + ". odd " + N);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}