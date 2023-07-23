import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int gcd;
    static ArrayList<Integer> res;

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        res = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        gcd = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            gcd = getGCD(gcd, Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                res.add(i);
                if (i * i == gcd) {
                    break;
                }
                res.add(gcd / i);
            }
        }

        Collections.sort(res);

        for (int i : res) {
            sb.append(i).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
