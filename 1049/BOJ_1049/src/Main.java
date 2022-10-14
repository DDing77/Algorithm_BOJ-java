import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] bundle;
    static int[] single;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bundle = new int[M];
        single = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bundle[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bundle);
        Arrays.sort(single);

        int minBundle = bundle[0];

        for (int s : single) {
            if (minBundle > (s * 6)) minBundle = s * 6;
        }

        int pack = (N / 6 + 1) * minBundle;
        int allSingle = (N / 6) * minBundle + (N % 6) * single[0];

        System.out.println(pack < allSingle ? pack : allSingle);
    }
}
