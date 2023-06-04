import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String[] str;
    static int type;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        type = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cur = str[i];
            String reverse = str[str.length - 1 - i];

            for (int j = 0; j < N; j++) {
                if (type == 1) {
                    sb.append(cur.charAt(j));
                } else if (type == 2) {
                    sb.append(cur.charAt(cur.length() - 1 - j));
                } else if (type == 3) {
                    sb.append(reverse.charAt(j));
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}