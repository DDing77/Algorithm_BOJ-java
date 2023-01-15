import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static int N;
    static int[] favorites;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        favorites = new int[N];
        for (int i = 0; i < N; i++) {
            favorites[i] = Integer.parseInt(br.readLine());
        }

        int diff;
        res = 1000;
        for (int i = 0; i < N; i++) {
            diff = Math.abs(favorites[i] - B);
            if (res > diff) res = diff;
        }

        res = (res + 1) < Math.abs(A - B) ? res + 1 : Math.abs(A - B);

        System.out.println(res);
    }
}
