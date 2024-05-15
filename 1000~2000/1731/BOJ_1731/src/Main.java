import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] numbers;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int diff = numbers[1] - numbers[0];
        if (diff == numbers[2] - numbers[1]) {
            System.out.println(numbers[N - 1] + diff);
        } else {
            System.out.println(numbers[N - 1] * (numbers[1] / numbers[0]));
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
