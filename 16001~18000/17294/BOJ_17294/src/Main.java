import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private char[] k;

    private void solution() throws IOException {

        k = br.readLine().toCharArray();
        if (k.length <= 2) {
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            return;
        }

        int diff = k[1] - k[0];
        for (int i = 2; i < k.length; i++) {
            if (diff != k[i] - k[i - 1]) {
                System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
                return;
            }
        }

        System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
