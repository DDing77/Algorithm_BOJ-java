import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int M;
    private String dna;
    private int L;

    private int charIndex(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else { // 'T'
            return 3;
        }
    }

    private void solution() throws IOException {
        M = Integer.parseInt(br.readLine().trim());
        dna = br.readLine().trim();
        L = dna.length();

        int answer = Integer.MAX_VALUE;

        int maxP = Math.min(M, L);
        for (int p = 1; p <= maxP; p++) {

            int cost = 0;

            for (int r = 0; r < p; r++) {

                int[] freq = new int[4];
                int groupSize = 0;

                for (int i = r; i < L; i += p) {
                    char c = dna.charAt(i);
                    freq[charIndex(c)]++;
                    groupSize++;
                }

                if (groupSize == 0) {
                    continue;
                }

                int maxFreq = 0;
                for (int k = 0; k < 4; k++) {
                    if (freq[k] > maxFreq) {
                        maxFreq = freq[k];
                    }
                }

                cost += groupSize - maxFreq;
                if (cost >= answer) {
                    break;
                }
            }

            if (cost < answer) {
                answer = cost;
            }
        }

        sb.append(answer).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
