import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            arr[i] = sum;
        }

        int max = Integer.MIN_VALUE;
        int idx = -1;

        for (int i = 0; i < 5; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i + 1;
            }
        }

        System.out.println(idx + " " + max);
    }
}
