import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int S;
    int P;
    String DNA;
    int[] need;
    int[] cnt;
    int res;

    public boolean check() {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] < need[i]) {
                return false;
            }
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        DNA = br.readLine();

        need = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        cnt = new int[4];
        res = 0;
        for (int i = 0; i < P; i++) {
            char cur = DNA.charAt(i);
            if (cur == 'A') {
                cnt[0]++;
            } else if (cur == 'C') {
                cnt[1]++;
            } else if (cur == 'G') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }
        }

        if (check()) {
            res++;
        }

        for (int i = P; i < S; i++) {
            char pre = DNA.charAt(i - P);
            if (pre == 'A') {
                cnt[0]--;
            } else if (pre == 'C') {
                cnt[1]--;
            } else if (pre == 'G') {
                cnt[2]--;
            } else {
                cnt[3]--;
            }

            char cur = DNA.charAt(i);
            if (cur == 'A') {
                cnt[0]++;
            } else if (cur == 'C') {
                cnt[1]++;
            } else if (cur == 'G') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }

            if (check()) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
