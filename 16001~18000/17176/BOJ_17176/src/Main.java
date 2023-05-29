import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int[] alphaA, alphaB;
    private char[] chars;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        alphaA = new int[53];
        alphaB = new int[53];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            alphaA[Integer.parseInt(st.nextToken())]++;
        }

        chars = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            char cur = chars[i];
            if ('A' <= cur && cur <= 'Z') {
                alphaB[cur - 64]++;
            } else if ('a' <= cur && cur <= 'z') {
                alphaB[cur - 70]++;
            } else {
                alphaB[0]++;
            }
        }

        for (int i = 0; i < 53; i++) {
            if (alphaA[i] != alphaB[i]) {
                System.out.println("n");
                return;
            }
        }

        System.out.println("y");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
