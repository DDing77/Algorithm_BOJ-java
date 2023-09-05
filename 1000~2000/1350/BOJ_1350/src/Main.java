import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[] fileSize;
    int cluster;
    long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        fileSize = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fileSize[i] = Integer.parseInt(st.nextToken());
        }

        cluster = Integer.parseInt(br.readLine());
        res = 0L;

        for (int i = 0; i < N; i++) {
            res += (fileSize[i] / cluster) * cluster;

            if (fileSize[i] % cluster != 0) {
                res += cluster;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
