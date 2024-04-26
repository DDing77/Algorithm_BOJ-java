import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String[] first;
    private String[] second;

    private void solution() throws IOException {

        first = br.readLine().split(":");
        second = br.readLine().split(":");

        int firstTime = Integer.parseInt(first[0]) * 3600 + Integer.parseInt(first[1]) * 60 + Integer.parseInt(first[2]);
        int secondTime = Integer.parseInt(second[0]) * 3600 + Integer.parseInt(second[1]) * 60 + Integer.parseInt(second[2]);

        int diff = secondTime - firstTime;
        if (diff <= 0) {
            diff = 24 * 3600 + diff;
        }

        int hour = diff / 3600;
        int min = (diff % 3600) / 60;
        int sec = diff % 60;

        sb.append(String.format("%02d", hour)).append(":")
                .append(String.format("%02d", min)).append(":")
                .append(String.format("%02d", sec));
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
