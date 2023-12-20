import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    int M;
    int a;
    int b;
    int s;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());

        int belt = 0;
        int beltm = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            if (s == 1) {
                if (belt == 0) {
                    belt = 1;
                } else if (belt == 1) {
                    belt = 0;
                }
            }

            beltm = (beltm / a) * b;
        }
        System.out.println(belt + " " + beltm);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
