import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n;
    static int res;

    static HashMap<String, Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            list = new HashMap<>();
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                list.put(b, list.getOrDefault(b, 0) + 1);
            }

            res = 1;
            for (int val : list.values()) {
                res *= (val + 1);
            }

            res -= 1;

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
