import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static String[] name;
    static int[] bev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int school = Integer.parseInt(br.readLine());

            name = new String[school];
            bev = new int[school];

            for (int k = 0; k < school; k++) {
                st = new StringTokenizer(br.readLine());
                name[k] = st.nextToken();
                bev[k] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            int max = bev[0];

            for (int k = 0; k < bev.length; k++) {
                if (max < bev[k]) {
                    max = bev[k];
                    idx = k;
                }
            }
            sb.append(name[idx]).append('\n');
        }
        System.out.print(sb);
    }
}
