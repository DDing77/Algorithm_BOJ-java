import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;
    private int count;

    private void solution() throws IOException {

        br.readLine();

        while (true) {
            input = br.readLine();
            if (input.equals("고무오리 디버깅 끝")) {
                break;
            }

            if (input.charAt(0) == '문') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                count = 2;
            }
        }

        if (count == 0) {
            System.out.println("고무오리야 사랑해");
        } else {
            System.out.println("힝구");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
