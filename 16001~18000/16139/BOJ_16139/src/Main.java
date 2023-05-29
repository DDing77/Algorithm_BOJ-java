import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private String input;
    private int q;
    private int[][] sum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        input = br.readLine();
        sum = new int[26][input.length() + 1];
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (i - 1 >= 0) {
                    sum[j][i] = sum[j][i - 1];
                }
            }
            char ch = input.charAt(i);
            sum[ch - 'a'][i]++;
        }

        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) {
                sb.append(sum[ch - 'a'][r]);
            } else {
                sb.append(sum[ch - 'a'][r] - sum[ch - 'a'][l - 1]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
