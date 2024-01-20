import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    int res = 0;
    String input;

    private void solution() throws IOException {
        input = br.readLine();

        for (int i = 0; i < input.length() - 3; i++) {
//            System.out.println("i = " + i);
            if (input.charAt(i) != 'D') {
                continue;
            }

            if (input.startsWith("DKSH", i)) {
                res++;
                i += 3;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
