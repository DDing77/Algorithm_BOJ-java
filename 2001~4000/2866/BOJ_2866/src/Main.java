import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int R;
    int C;
    StringBuilder[] table;

    private boolean check(int mid) {
//        System.out.println("mid = " + mid);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < C; i++) {
            String sub = table[i].substring(mid);
//            System.out.println("sub = " + sub);
            if (set.contains(sub)) {
                return false;
            } else {
                set.add(sub);
            }
        }

        return true;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        table = new StringBuilder[C];
        for (int i = 0; i < C; i++) {
            table[i] = new StringBuilder();
        }

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                table[j].append(input.charAt(j));
            }
        }

        int left = 0;
        int right = R;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
