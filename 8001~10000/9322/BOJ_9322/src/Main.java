import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    int T;
    int N;
    HashMap<String, Integer> pubKey1;
    String[] pubKey2;
    String[] encryptKey;
    String[] res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            pubKey1 = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pubKey1.put(st.nextToken(), i);
            }

            pubKey2 = br.readLine().split(" ");

            encryptKey = br.readLine().split(" ");

            res = new String[N];
            for (int i = 0; i < N; i++) {
                res[pubKey1.get(pubKey2[i])] = encryptKey[i];
            }

            for (int i = 0; i < N; i++) {
                sb.append(res[i] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
