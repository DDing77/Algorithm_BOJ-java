import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, X;
    static String S;
    static HashMap<String, Integer> cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cards = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            S = st.nextToken();
            X = Integer.parseInt(st.nextToken());

            cards.put(S, cards.getOrDefault(S, 0) + X);
        }

        for (int key : cards.values()) {
            if (key == 5) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
