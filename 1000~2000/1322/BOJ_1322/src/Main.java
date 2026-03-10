import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        String x = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
        String k = Integer.toBinaryString(Integer.parseInt(st.nextToken()));

        int index = k.length() - 1;
        StringBuilder result = new StringBuilder();

        for (int i = x.length() - 1; i >= 0; i--) {
            char c = x.charAt(i);

            if (c == '1') {
                result.append('0');
            } else {
                if (index >= 0) {
                    result.append(k.charAt(index--));
                } else {
                    break;
                }
            }
        }

        for (int i = index; i >= 0; i--) {
            result.append(k.charAt(i));
        }

        long answer = Long.parseLong(result.reverse().toString(), 2);
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}