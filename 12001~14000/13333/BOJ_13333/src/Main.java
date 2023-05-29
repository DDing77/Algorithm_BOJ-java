import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        papers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(papers);

        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= papers[j] && i <= n-j && n-i <= j+1) {
                    if (i == n - j) {
                        res = Math.max(res, i);
                    }
                }
            }
        }

        System.out.println(res);
    }
}
