import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    private int N, K;
    private List<Integer>[] programs;
    private int[] count;

    private int[] getPi(List<Integer> pattern) {
        int m = pattern.size();
        int[] pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && !pattern.get(i).equals(pattern.get(j))) {
                j = pi[j - 1];
            }
            if (pattern.get(i).equals(pattern.get(j))) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    private boolean containsPattern(List<Integer> text, List<Integer> pattern) {
        int[] pi = getPi(pattern);
        int n = text.size(), m = pattern.size();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && !text.get(i).equals(pattern.get(j))) {
                j = pi[j - 1];
            }
            if (text.get(i).equals(pattern.get(j))) {
                j++;
                if (j == m) return true;
            }
        }
        return false;
    }

    private void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        programs = new ArrayList[N];
        count = new int[10001];

        for (int i = 0; i < N; i++) {
            programs[i] = new ArrayList<>();
            br.readLine();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                programs[i].add(num);
                count[num]++;
            }
        }

        List<Integer> base = programs[0];
        for (int start = 0; start <= base.size() - K; start++) {
            List<Integer> virus = base.subList(start, start + K);

            boolean valid = true;
            for (int num : virus) {
                if (count[num] < N) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            List<Integer> virusRev = new ArrayList<>(virus);
            Collections.reverse(virusRev);

            boolean found = true;
            for (int i = 1; i < N; i++) {
                if (!containsPattern(programs[i], virus) && !containsPattern(programs[i], virusRev)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
