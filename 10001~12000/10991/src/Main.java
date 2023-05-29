import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String str = "* ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = i; j < N; j++) sb.append(" ");
            for (int j = 0; j < i; j++) sb.append(str);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}