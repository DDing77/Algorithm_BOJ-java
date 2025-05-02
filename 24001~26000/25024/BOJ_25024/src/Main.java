import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int T;
    private int x;
    private int y;

    private boolean isTime() {
        if (x <= 23 && y <= 59) {
            return true;
        }
        return false;
    }

    private boolean isCalendar() {
        if (1 <= x && x <= 12) {
            if (1 <= y && y <= days[x]) {
                return true;
            }
        }
        return false;
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (isTime()) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append(" ");

            if (isCalendar()) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
