import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static long require;

    static boolean determine(int h) {
        long sum = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] - h > 0) {
                sum += tree[i] - h;
            }
        }
        if (sum >= require) {
            return true;
        }
        return false;
    }

    static void param_search() {
        long L = 0, R = 2000000000, ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determine((int) mid)) {
                ans = mid;
                L = mid +1;
            } else{
                R = mid -1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        require  = Long.parseLong(st.nextToken());

        tree = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i ++){
            tree[i] = Long.parseLong(st.nextToken());
        }
        param_search();
    }
}
