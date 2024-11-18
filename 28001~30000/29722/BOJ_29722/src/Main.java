import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {

        String[] date = br.readLine().split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        int N = Integer.parseInt(br.readLine());
        day += N;
        month += (day - 1) / 30;
        year += (month - 1) / 12;
        day = (day - 1) % 30 + 1;
        month = (month - 1) % 12 + 1;

        sb.append(year).append("-").append(String.format("%02d", month)).append("-").append(String.format("%02d", day));
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
