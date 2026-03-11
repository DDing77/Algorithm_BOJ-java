import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        int month = (N - 1) * 7 + 8;
        int year = 2024;
        if (month % 12 == 0) {
            year += (month / 12) - 1;
            month = 12;
        } else {
            year += month / 12;
            month %= 12;
        }
        System.out.println(year + " " + month);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
