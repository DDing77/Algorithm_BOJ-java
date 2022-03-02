import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, B, C;
    static long res = 0;
    static long[] factories;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if( B < C) C = B;
        factories = new long[1000010];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) factories[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            if (factories[i + 1] > factories[i + 2]) {
                long minTwo = Math.min(factories[i], factories[i + 1] - factories[i + 2]);
                factories[i] -= minTwo;
                factories[i + 1] -= minTwo;
                res += minTwo * (B + C);

                long minThree = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                factories[i] -= minThree;
                factories[i + 1] -= minThree;
                factories[i + 2] -= minThree;
                res += minThree * (B + C + C);
            } else {
                long minThree = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                factories[i] -= minThree;
                factories[i + 1] -= minThree;
                factories[i + 2] -= minThree;
                res += minThree * (B + C + C);

                long minTwo = Math.min(factories[i], factories[i+1]);
                factories[i] -= minTwo;
                factories[i+1] -= minTwo;
                res += minTwo * (B + C);
            }
            res += factories[i] * B;
        }

        System.out.println(res);
    }
}
