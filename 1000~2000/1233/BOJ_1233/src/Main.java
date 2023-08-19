import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int S1;
    int S2;
    int S3;
    int[] cnt;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S1 = Integer.parseInt(st.nextToken());
        S2 = Integer.parseInt(st.nextToken());
        S3 = Integer.parseInt(st.nextToken());

        cnt = new int[S1 + S2 + S3 + 1];

        int max = 3;
        int res = 3;
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    cnt[i + j + k]++;
                    if (max < cnt[i + j + k]) {
                        res = i + j + k;
                        max = cnt[i + j + k];
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
