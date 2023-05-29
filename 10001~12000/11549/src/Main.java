import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == t) ans++;
        }
        System.out.println(ans);
    }
}