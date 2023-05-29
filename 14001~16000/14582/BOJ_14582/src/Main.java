import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = new int[9];
        b = new int[9];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) b[i] = Integer.parseInt(st.nextToken());

        int scoreA = 0;
        int scoreB = 0;

        boolean flag = false;
        for (int i = 0; i < 9; i++) {
            scoreA += a[i];
            if (scoreA > scoreB) {
                flag = true;
                break;
            }
            scoreB += b[i];
        }

        if (!flag) System.out.println("No");
        else System.out.println("Yes");
    }
}
