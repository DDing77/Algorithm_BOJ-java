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
    private Set<String> set;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (words[i].length() <= words[j].length()) {
                    for (int k = 0; k < words[i].length(); k++) {
                        if (words[i].equals(words[j])) {
                            cnt++;
                            break;
                        }
                        if (words[i].charAt(k) != words[j].charAt(k)) {
                            cnt++;
                            break;
                        }
                    }
                } else {
                    cnt++;
                }
            }

            if (cnt == N - 1) {
                set.add(words[i]);
            }
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
