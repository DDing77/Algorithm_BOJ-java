import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    String[] start;
    String[] end;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        start = br.readLine().split(":");
        end = br.readLine().split(":");

        int startTime = Integer.parseInt(start[0]) * 3600 + Integer.parseInt(start[1]) * 60 + Integer.parseInt(start[2]);
        int endTime = Integer.parseInt(end[0]) * 3600 + Integer.parseInt(end[1]) * 60 + Integer.parseInt(end[2]);

        if (startTime > endTime) {
            endTime += 24 * 3600;
        }

        int diff = endTime - startTime;
        int hour = diff / 3600;
        int min = (diff % 3600) / 60;
        int sec = (diff % 3600) % 60;

        sb.append(String.format("%02d", hour)).append(":");
        sb.append(String.format("%02d", min)).append(":");
        sb.append(String.format("%02d", sec));
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
