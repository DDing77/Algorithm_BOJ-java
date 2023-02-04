import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static int original, ea, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            original = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                ea = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                original += ea * cost;
            }

            sb.append(original).append('\n');
        }
        System.out.print(sb);
    }
}
