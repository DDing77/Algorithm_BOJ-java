import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        res = 1;

        if (input.charAt(0) == 'c') {
            res = 26;
        } else {
            res = 10;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            char a = input.charAt(i);
            char b = input.charAt(i + 1);

            if (a == 'c') {
                if (a == b) {
                    res *= 25;
                } else {
                    res *= 10;
                }
            } else {
                if (a == b) {
                    res *= 9;
                } else {
                    res *= 26;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
