import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private char[] aChars;
    private char[] bChars;
    private int b;
    private boolean[] isVisited;
    private int resMin;

    private int convertToNum(char[] chars) {
        int num = 0;

        for (char ch : chars) {
            num *= 10;
            num += ch - '0';
        }

        return num;
    }

    private void backTracking(int depth, char[] curNum) {

        if (depth == aChars.length && convertToNum(curNum) < b) {
            resMin = Math.max(resMin, convertToNum(curNum));
            return;
        }

        if (curNum[0] == '0') {
            return;
        }

        for (int i = 0; i < aChars.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                curNum[depth] = aChars[i];
                backTracking(depth + 1, curNum);
                isVisited[i] = false;
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        aChars = st.nextToken().toCharArray();
        bChars = st.nextToken().toCharArray();

        b = convertToNum(bChars);
        isVisited = new boolean[aChars.length];
        resMin = -1;
        backTracking(0, new char[aChars.length]);

        System.out.println(resMin);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
