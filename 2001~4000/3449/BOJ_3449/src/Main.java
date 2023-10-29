import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int T;
    String[] input;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = new String[2];
            input[0] = br.readLine();
            input[1] = br.readLine();

            res = 0;
            for (int i = 0; i < input[0].length(); i++) {
                if (input[0].charAt(i) != input[1].charAt(i)) {
                    res++;
                }
            }
            sb.append("Hamming distance is ").append(res).append(".").append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
