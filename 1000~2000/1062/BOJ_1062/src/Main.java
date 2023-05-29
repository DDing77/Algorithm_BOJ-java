import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int res;
    static String[] data;

    static void dfs(int idx, int cnt, int bitmask) {
        if (cnt == k) {
            int check = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < data[i].length(); j++) {
                    if ((bitmask & (1 << data[i].charAt(j) - 96)) == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) check++;
            }
            res = Math.max(res, check);
            return;
        }

        for (int i = idx; i < 27; i++) {
            if ((bitmask & (1 << i)) == 0) {
                dfs(i + 1, cnt + 1, bitmask | (1 << i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        data = new String[n];

        int mask = 0;
        mask |= 1 << (int) 'a' - 'a' + 1;
        mask |= 1 << (int) 'c' - 'a' + 1;
        mask |= 1 << (int) 'i' - 'a' + 1;
        mask |= 1 << (int) 'n' - 'a' + 1;
        mask |= 1 << (int) 't' - 'a' + 1;


        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            str = str.replace("a", "");
            str = str.replace("c", "");
            str = str.replace("i", "");
            str = str.replace("n", "");
            str = str.replace("t", "");
            data[i] = str;
        }

        dfs(0, 5, mask);

        System.out.println(res);
    }


}