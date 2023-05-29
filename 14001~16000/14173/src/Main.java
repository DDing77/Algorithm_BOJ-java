import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[4];
        for (int i = 0; i < 4; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        b = new int[4];
        for (int i = 0; i < 4; i++) b[i] = Integer.parseInt(st.nextToken());

        int X = Math.max(a[2], b[2]) - Math.min(a[0], b[0]);
        int Y = Math.max(a[3], b[3]) - Math.min(a[1], b[1]);
        int res = Math.max(X, Y);

        System.out.println(res * res);
    }
}
