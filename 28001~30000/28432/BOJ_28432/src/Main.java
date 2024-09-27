import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String[] words;
    private String[] candidates;
    private int M;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        int targetIdx = -1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            set.add(words[i]);
            if (words[i].equals("?")) {
                targetIdx = i;
            }
        }


        M = Integer.parseInt(br.readLine());
        candidates = new String[M];
        for (int i = 0; i < M; i++) {
            candidates[i] = br.readLine();
        }

        if (N == 1) {
            System.out.println(candidates[0]);
            return;
        }

        for (int i = 0; i < M; i++) {
            String candi = candidates[i];
            if (set.contains(candi)) {
                continue;
            }
            if (targetIdx == 0) {
                if (candi.charAt(candi.length() - 1) == words[targetIdx + 1].charAt(0)) {
                    System.out.println(candi);
                    return;
                }
            } else if (targetIdx == N - 1) {
                if (candi.charAt(0) == words[targetIdx - 1].charAt(words[targetIdx - 1].length() - 1)) {
                    System.out.println(candi);
                    return;
                }
            } else {
                if (words[targetIdx - 1].charAt(words[targetIdx - 1].length() - 1) == candi.charAt(0)
                        && candi.charAt(candi.length() - 1) == words[targetIdx + 1].charAt(0)) {
                    System.out.println(candi);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
