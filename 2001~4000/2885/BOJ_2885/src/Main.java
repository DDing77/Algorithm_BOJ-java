import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int K;

    private void solution() throws IOException {
        K = Integer.parseInt(br.readLine());

        int cur = 1;
        while (K > cur) {
            cur *= 2;
        }

        int res = K | cur;
        int leftIdx = 0;
        String str = Integer.toBinaryString(res);
        while (str.charAt(leftIdx) != '1') {
            leftIdx++;
        }

        int rightIdx = str.length() - 1;
        while (str.charAt(rightIdx) != '1') {
            rightIdx--;
        }

        sb.append(cur).append(" ").append(rightIdx - leftIdx);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
