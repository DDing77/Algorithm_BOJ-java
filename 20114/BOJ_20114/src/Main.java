import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N, H, W;
    private String[] input;
    private StringBuilder sb;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        input = new String[H];
        for (int i = 0; i < H; i++) {
            input[i] = br.readLine();
        }

        sb = new StringBuilder();
        for (int i = 0; i < N * W; i += W) {
            boolean isFind = false;
            out:
            for (int j = 0; j < H; j++) {
                for (int k = i; k < i + W; k++) {
                    if (input[j].charAt(k) != '?') {
                        sb.append(input[j].charAt(k));
                        isFind = true;
                        break out;
                    }
                }

            }
            if (!isFind) {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
