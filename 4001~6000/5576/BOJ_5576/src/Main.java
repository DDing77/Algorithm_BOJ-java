import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] W;
    static int[] K;

    public static int getScore(int[] arr) {
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += arr[arr.length - i - 1];
        }

        return sum;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = new int[10];
        for (int i = 0; i < 10; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }

        K = new int[10];
        for (int i = 0; i < 10; i++) {
            K[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getScore(W) + " " + getScore(K));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
