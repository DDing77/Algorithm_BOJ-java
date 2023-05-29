import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] tree;

    static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = Integer.parseInt(br.readLine());

        int res = 0;
        int gcd = tree[2] - tree[1];

        for (int i = 3; i < N; i++) gcd = getGcd(gcd, tree[i + 1] - tree[i]);

        for (int i = 1; i < N; i++) {
            int length = tree[i + 1] - tree[i];
            res += length / gcd - 1;
        }


        System.out.println(res);
    }
}
