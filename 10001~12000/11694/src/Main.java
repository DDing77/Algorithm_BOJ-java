import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt1;
    static boolean flag;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        p = new int[N];

        long res = 0;
        flag = false;
        cnt1 = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            res ^= p[i];

            if (p[i] != 1) flag = true;
            else cnt1++;
        }

        if (!flag) {
            if (cnt1 % 2 == 1) System.out.println("cubelover");
            else System.out.println("koosaga");
        } else {
            if (cnt1 != 0) {
                if (cnt1 % 2 == 1 && res != 0) System.out.println("koosaga");
                else if (cnt1 % 2 == 1 && res == 0) System.out.println("cubelover");
                else if (cnt1 % 2 == 0) {
                    for (int i = 0; i < N; i++) {
                        if (p[i] != 1) {
                            p[i] = 1;
                            break;
                        }
                    }
                    res = 0;
                    for (int i = 0; i < N; i++) res ^= p[i];

                    if (res != 0) System.out.println("koosaga");
                    else System.out.println("cubelover");
                }
            } else System.out.println((res != 0) ? "koosaga" : "cubelover");
        }
    }
}
