import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int apple;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        apple = Integer.parseInt(br.readLine());
        int left = 1;
        int right = M;

        res = 0;
        for (int i = 0; i < apple; i++) {
            int diff;
            int number = Integer.parseInt(br.readLine());
            if (left <= number && number <= right) continue;
            else if (number < left) {
                res += left - number;
                diff = left - number;
                left -= diff;
                right -= diff;
            } else if (right < number) {
                res += number - right;
                diff = number - right;
                right += diff;
                left += diff;
            }
        }
        System.out.println(res);
    }
}
