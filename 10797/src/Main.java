import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int res = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            if (N == Integer.parseInt(st.nextToken())) res++;
        }

        System.out.println(res);
    }
}
