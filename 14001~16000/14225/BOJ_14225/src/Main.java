import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[] numbers;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int sum = 0;
        for (int number : numbers) {
            if(sum + 1 < number) {
                System.out.println(sum + 1);
                return;
            }
            sum += number;
        }

        System.out.println(sum + 1);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
