import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int x;
    int n;
    int[] blocks;

    private void solution() throws IOException {

        try {
            while (true) {
                x = Integer.parseInt(br.readLine()) * 10000000;
                n = Integer.parseInt(br.readLine());

                blocks = new int[n];
                for (int i = 0; i < n; i++) {
                    blocks[i] = Integer.parseInt(br.readLine());
                }

                Arrays.sort(blocks);

                int left = 0;
                int right = n - 1;

                while (left < right) {
                    int sum = blocks[left] + blocks[right];
                    if (sum == x) {
                        break;
                    }

                    if (sum < x) {
                        left++;
                    }

                    if (sum > x) {
                        right--;
                    }
                }

                if (left >= right) {
                    sb.append("danger").append("\n");
                } else {
                    sb.append("yes" + " ").append(blocks[left]).append(" ").append(blocks[right]).append("\n");
                }
            }
        } catch (Exception e) {
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
