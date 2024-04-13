import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    String A;
    String B;

    private void solution() throws IOException {

        A = br.readLine();
        B = br.readLine();

        // &
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a == '1') {
                if (b == '1') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            } else {
                sb.append('0');
            }
        }
        sb.append("\n");

        // |
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a == '1' || b == '1') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        sb.append("\n");

        // ^
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a != b) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        sb.append("\n");

        // ~A
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            if (a == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        sb.append("\n");

        // ~B
        for (int i = 0; i < A.length(); i++) {
            char b = B.charAt(i);
            if (b == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        sb.append("\n");

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
