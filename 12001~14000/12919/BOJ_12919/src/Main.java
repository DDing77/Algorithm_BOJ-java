import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    String S;
    String T;
    int res;

    private void recursion(String str) {
        if (str.equals(S)) {
            res = 1;
            return;
        }

        if (str.length() == S.length()) {
            return;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            recursion(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B') {
            recursion(new StringBuilder(str.substring(1)).reverse().toString());
        }
    }

    private void solution() throws IOException {

        S = br.readLine();
        T = br.readLine();

        res = 0;

        recursion(T);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
