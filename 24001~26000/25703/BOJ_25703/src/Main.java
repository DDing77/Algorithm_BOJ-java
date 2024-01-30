import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private String getStart(int length) {

        StringBuilder start = new StringBuilder();

        for (int i = 0; i < length; i++) {
            start.append("*");
        }
        return start.toString();
    }

    private void solution() throws IOException {

        sb.append("int a;").append("\n");
        String pre = "a";
        String cur;

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            cur = "ptr";
            if (i != 1) {
                cur += String.valueOf(i);
            }

            sb.append("int ")
                    .append(getStart(i))
                    .append(cur)
                    .append(" = ")
                    .append("&")
                    .append(pre)
                    .append(";")
                    .append("\n");

            pre = cur;
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
