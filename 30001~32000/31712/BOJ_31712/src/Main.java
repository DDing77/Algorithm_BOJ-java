import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int[][] skills;
    private int H;

    private void solution() throws IOException {
        skills = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            skills[i][0] = Integer.parseInt(st.nextToken());
            skills[i][1] = Integer.parseInt(st.nextToken());
        }

        H = Integer.parseInt(br.readLine());
        for (int i = 0; i < 3; i++) {
            H -= skills[i][1];
        }

        if (H <= 0) {
            System.out.println(0);
            return;
        }

        int sec = 1;
        while (true) {
            if (sec % skills[0][0] == 0) {
                H -= skills[0][1];
            }
            if (sec % skills[1][0] == 0) {
                H -= skills[1][1];
            }
            if (sec % skills[2][0] == 0) {
                H -= skills[2][1];
            }
            if (H <= 0) {
                break;
            }
            sec++;
        }
        System.out.println(sec);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
