import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int citation = arr[n - 1 - i];

            if (citation >= i + 1) {
                answer = i + 1;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}