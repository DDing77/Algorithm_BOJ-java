import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    private int N;
    private HashSet<Integer> numbers;
    private int[] arr;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        numbers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                numbers.add(arr[i] + arr[j]);
            }
        }

        res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++)
                if (numbers.contains(arr[j] - arr[i])) {
                    res = Math.max(res, arr[j]);
                }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
