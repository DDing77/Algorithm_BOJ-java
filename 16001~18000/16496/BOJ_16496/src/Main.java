import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String[] numberStrArr;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numberStrArr = new String[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberStrArr[i] = st.nextToken();
        }

        Arrays.sort(numberStrArr, (o1, o2) -> o2.concat(o1).compareTo(o1.concat(o2)));

        if (numberStrArr[0].equals("0")) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            sb.append(numberStrArr[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
