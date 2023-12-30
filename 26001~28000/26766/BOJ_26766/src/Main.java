import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;

    private StringBuilder getStringBuilder() {
        StringBuilder res = new StringBuilder();
        res.append(" @@@   @@@ ").append("\n");
        res.append("@   @ @   @").append("\n");
        res.append("@    @    @").append("\n");
        res.append("@         @").append("\n");
        res.append(" @       @ ").append("\n");
        res.append("  @     @  ").append("\n");
        res.append("   @   @   ").append("\n");
        res.append("    @ @    ").append("\n");
        res.append("     @     ").append("\n");

        return res;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            sb.append(getStringBuilder());
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
