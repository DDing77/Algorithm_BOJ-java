import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int res = 0;
    static int[] factories;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        factories = new int[N + 3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) factories[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (factories[i + 1] <= factories[i + 2]) {
                int minThree = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                res += minThree * 7;
                for (int j = 0; j < 3; j++) {
                    factories[i + j] -= minThree;
                }

                int minTwo = Math.min(factories[i], factories[i + 1]);
                res += minTwo * 5;
                for (int j = 0; j < 2; j++) {
                    factories[i + j] -= minTwo;
                }
            } else {
                int minTwo = Math.min(factories[i], factories[i + 1] - factories[i + 2]);
                res += minTwo * 5;
                for (int j = 0; j < 2; j++) {
                    factories[i + j] -= minTwo;
                }

                int minThree = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                res += minThree * 7;
                for (int j = 0; j < 3; j++) {
                    factories[i + j] -= minThree;
                }
            }
            res += factories[i] * 3;
        }
        System.out.println(res);
    }
}
