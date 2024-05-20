import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int day;
    private int month;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        day = Integer.parseInt(st.nextToken());
        month = Integer.parseInt(st.nextToken());

        int totalDay = day;
        for (int i = 0; i < month; i++) {
            totalDay += days[i];
        }

        int remain = totalDay % 7;
        if (remain == 1) {
            System.out.println("Thursday");
        } else if (remain == 2) {
            System.out.println("Friday");
        } else if (remain == 3) {
            System.out.println("Saturday");
        } else if (remain == 4) {
            System.out.println("Sunday");
        } else if (remain == 5) {
            System.out.println("Monday");
        } else if (remain == 6) {
            System.out.println("Tuesday");
        } else {
            System.out.println("Wednesday");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
