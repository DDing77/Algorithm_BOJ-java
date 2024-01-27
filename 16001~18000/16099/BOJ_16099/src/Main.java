import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int T;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long telecom = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
            long eure = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());

            if (telecom > eure) {
                sb.append("TelecomParisTech");
            } else if (telecom < eure) {
                sb.append("Eurecom");
            } else {
                sb.append("Tie");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
