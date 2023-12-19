import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] numbers;

    private int lowerBound(int min) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] >= min) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int upperBound(int max) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] <= max) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int lowerIdx = lowerBound(Integer.parseInt(st.nextToken()));
            int upperIdx = upperBound(Integer.parseInt(st.nextToken()));

            sb.append(upperIdx - lowerIdx).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}