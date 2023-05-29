import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int cnt;
    static StringBuilder temp;
    static long[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cnt = n;
        numbers = new long[n];
        int idx = 0;
        while (st.hasMoreTokens()) {
            cnt--;
            temp = new StringBuilder(st.nextToken());
            numbers[idx++] = Long.parseLong(temp.reverse().toString());
        }

        while (cnt > 0) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                cnt--;
                temp = new StringBuilder(st.nextToken());
                numbers[idx++] = Long.parseLong(temp.reverse().toString());
            }
        }

        Arrays.sort(numbers);

        for (long str : numbers) {
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }
}
