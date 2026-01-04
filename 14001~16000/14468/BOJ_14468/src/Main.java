import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int LENGTH = 52;

    private char[] alphaArr;
    private int[][] posArr;
    private int res;

    private void solution() throws IOException {
        alphaArr = br.readLine().toCharArray();
        posArr = new int[26][2];

        for (int i = 0; i < LENGTH; i++) {
            int charIdx = alphaArr[i] - 'A';
            if (posArr[charIdx][0] == 0) {
                posArr[charIdx][0] = i + 1;
            } else {
                posArr[charIdx][1] = i + 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (posArr[i][0] < posArr[j][0]
                        && posArr[j][0] < posArr[i][1]
                        && posArr[i][1] < posArr[j][1]) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
