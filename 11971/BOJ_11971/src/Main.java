import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, M;
    private int[] official, personal;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        official = new int[100];
        personal = new int[100];

        int lastIdx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            Arrays.fill(official, lastIdx, lastIdx + length, speed);
            lastIdx += length;
        }

        lastIdx = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            
            Arrays.fill(personal, lastIdx, lastIdx + length, speed);
            lastIdx += length;
        }

        res = 0;
        for (int i = 0; i < 100; i++) {
            if (res < personal[i] - official[i]) {
                res = personal[i] - official[i];
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
