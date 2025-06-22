import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private char[] isbn;

    private void solution() throws IOException {
        isbn = br.readLine().toCharArray();

        int sum = 0;
        int p = 0;
        for (int i = 0; i < isbn.length; i++) {
            if ((i & 1) == 0) {
                if (isbn[i] == '*') {
                    p = 1;
                } else {
                    sum += (isbn[i] - '0');
                }
            } else {
                if (isbn[i] == '*') {
                    p = 3;
                } else {
                    sum += (isbn[i] - '0') * 3;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if ((sum + i * p) % 10 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
