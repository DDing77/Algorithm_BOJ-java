import java.io.*;
import java.util.*;

public class Main {

    int T;
    int[] numbers;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            numbers = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            sb.append(numbers[0]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}