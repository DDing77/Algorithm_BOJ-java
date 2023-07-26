import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    int N;
    final String[] message = {"yummy", "sad"};
    HashSet<String> hashSet;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hashSet = new HashSet<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String cur = st.nextToken();
            String sub = "";
            if (cur.length() >= 6) {
                sub = cur.substring(cur.length() - 6);
            }
            if (sub.equals("Cheese")) {
                hashSet.add(cur);
            }
        }

        if (hashSet.size() >= 4) {
            System.out.println(message[0]);
        } else {
            System.out.println(message[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

