import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private boolean[] switchArr;
    private int res;

    private void solution() throws IOException {
        String input = br.readLine();

        int length = input.length();
        switchArr = new boolean[length + 1];
        for (int i = 1; i <= length; i++) {
            if (input.charAt(i - 1) == 'Y') {
                switchArr[i] = true;
            }
        }

        for (int i = 1; i <= length; i++) {
            if (switchArr[i]) {
                for (int j = i; j <= length; j += i) {
                    switchArr[j] = !switchArr[j];
                }
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
