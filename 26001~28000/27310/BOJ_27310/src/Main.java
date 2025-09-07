import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private char[] sentence;
    private int colonCnt;
    private int underLineCnt;

    private void solution() throws IOException {
        sentence = br.readLine().toCharArray();
        for (char c : sentence) {
            if (c == ':') {
                colonCnt++;
            } else if (c == '_') {
                underLineCnt++;
            }
        }

        System.out.println(sentence.length + colonCnt + underLineCnt * 5);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
