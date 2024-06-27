import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer>[] files;
    private int K;

    private boolean check(int idx) {
        HashSet<Integer> set = new HashSet<>();
        for (ArrayList<Integer> file : files) {
            if (idx < file.size()) {
                int num = file.get(idx);
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
            }
        }
        return true;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        files = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            files[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                files[i].add(num);
            }
        }

        K = 0;
        while (!check(K)) {
            K++;
        }

        System.out.println(K + 1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
