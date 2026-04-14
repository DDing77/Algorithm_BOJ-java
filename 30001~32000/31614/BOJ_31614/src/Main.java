import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int hour;
    private int minute;

    private void solution() throws IOException {
        hour = Integer.parseInt(br.readLine());
        minute = Integer.parseInt(br.readLine());

        System.out.println(hour * 60 + minute);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
