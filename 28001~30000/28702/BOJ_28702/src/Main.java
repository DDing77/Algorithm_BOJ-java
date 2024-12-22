import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String[] inputs;

    private String getNext(int idx) {

        if (idx % 3 == 0 && idx % 5 == 0) {
            return "FizzBuzz";
        } else if (idx % 3 == 0) {
            return "Fizz";
        } else if (idx % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(idx);
    }

    private void solution() throws IOException {

        for (int i = 3; i > 0; i--) {
            String cur = br.readLine();
            if (cur.matches("^[0-9]*$")) {
                int next = Integer.parseInt(cur) + i;

                System.out.println(getNext(next));
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
