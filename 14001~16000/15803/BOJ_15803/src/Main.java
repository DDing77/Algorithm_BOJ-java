import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final String[] messages = {
            "WINNER WINNER CHICKEN DINNER!",
            "WHERE IS MY CHICKEN?"
    };
    private int[][] dot;

    public boolean ccw(int[][] dot) {
        int a = dot[0][0] * dot[1][1] + dot[1][0] * dot[2][1] + dot[2][0] * dot[0][1];
        int b = dot[1][0] * dot[0][1] + dot[2][0] * dot[1][1] + dot[0][0] * dot[2][1];

        if (a == b) {
            return true;
        }

        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dot = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        if (!ccw(dot)) {
            System.out.println(messages[0]);
        } else {
            System.out.println(messages[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
