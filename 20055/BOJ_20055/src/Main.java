import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N, K;
    private int[] belt;
    private boolean[] robot;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[N * 2];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        while (K > 0) {
            int temp = belt[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[N - 1] = false;
            robot[0] = false;

            for (int i = N - 1; i > 0; i--) {
                if (!robot[i] && robot[i - 1] && belt[i] > 0) {
                    belt[i]--;
                    if (belt[i] == 0) {
                        K--;
                    }

                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            if (belt[0] > 0) {
                belt[0]--;
                if (belt[0] == 0) {
                    K--;
                }
                robot[0] = true;
            }
            res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}