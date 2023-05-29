import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            char[] aCh = a.toCharArray();
            char[] bCh = b.toCharArray();

            Arrays.sort(aCh);
            Arrays.sort(bCh);

            if (Arrays.equals(aCh, bCh)) {
                System.out.println(a + " & " + b + " are anagrams.");
            } else {
                System.out.println(a + " & " + b + " are NOT anagrams.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
