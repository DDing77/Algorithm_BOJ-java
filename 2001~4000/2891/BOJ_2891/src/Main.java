import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, S, R;
    private int[] teams;
    private int res;

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        teams = new int[N];
        Arrays.fill(teams, 1);

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < S; i++) {
            teams[Integer.parseInt(st.nextToken()) - 1]--;
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < R; i++) {
            teams[Integer.parseInt(st.nextToken()) - 1]++;
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (teams[0] == 2 && teams[1] == 0) {
                    teams[0] = 1;
                    teams[1] = 1;
                }
            } else if (i == N - 1) {
                if (teams[teams.length - 1] == 2 && teams[teams.length - 2] == 0) {
                    teams[N - 1] = 1;
                    teams[N - 2] = 1;
                }
            } else {
                if (teams[i] == 2) {
                    if (teams[i - 1] == 0) {
                        teams[i] = 1;
                        teams[i - 1] = 1;
                    } else if (teams[i + 1] == 0) {
                        teams[i] = 1;
                        teams[i + 1] = 1;
                    }
                }
            }
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            if (teams[i] == 0) {
                res++;
            }
        }

        System.out.println(res++);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}