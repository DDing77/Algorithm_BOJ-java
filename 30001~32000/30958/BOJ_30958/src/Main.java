import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] alphaCnt;
    private int resMax;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        alphaCnt = new int[26];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            for (int i = 0; i < word.length(); i++) {
                int alphaInt = word.charAt(i) - 'a';
                if (0 <= alphaInt && alphaInt <= 25) {
                    alphaCnt[word.charAt(i) - 'a']++;
                }
            }
        }

        for (int i = 0; i < alphaCnt.length; i++) {
            resMax = Math.max(resMax, alphaCnt[i]);
        }

        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
