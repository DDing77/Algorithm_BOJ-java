import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Cut[] cuts = new Cut[K];

        for (int i = 0; i < K; i++) {
            Cut cut = new Cut();
            st = new StringTokenizer(br.readLine());
            cut.cutStart = Integer.parseInt(st.nextToken());
            cut.cutEnd = Integer.parseInt(st.nextToken());
            cut.pasteAfter = Integer.parseInt(st.nextToken());
            cuts[i] = cut;
        }

        int[] firstTen = new int[11];
        for (int i = 1; i <= 10; i++) {
            firstTen[i] = i;
        }

        for (int idx = K - 1; idx >= 0; idx--) {
            int cutStart = cuts[idx].cutStart;
            int pasteStart = cuts[idx].pasteAfter + 1;
            int blockLength = cuts[idx].cutEnd - cuts[idx].cutStart + 1;

            for (int j = 1; j <= 10; j++) {
                int line = firstTen[j];

                if (line >= pasteStart && line < pasteStart + blockLength) {
                    firstTen[j] = cutStart + (line - pasteStart);
                } else if (line >= pasteStart + blockLength && line < cutStart + blockLength) {
                    firstTen[j] = line - blockLength;
                } else if (line < pasteStart && line >= cutStart) {
                    firstTen[j] = line + blockLength;
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            sb.append(firstTen[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private static class Cut {
        int cutStart;
        int cutEnd;
        int pasteAfter;
    }
}
