
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        int[] count = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                boolean visible = true;

                for (int k = i + 1; k < j; k++) {
                    long left = (long) (height[k] - height[i]) * (j - i);
                    long right = (long) (height[j] - height[i]) * (k - i);

                    if (left >= right) {
                        visible = false;
                        break;
                    }
                }

                if (visible) {
                    count[i]++;
                    count[j]++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, count[i]);
        }

        System.out.println(answer);
    }
}
