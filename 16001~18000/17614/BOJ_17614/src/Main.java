import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int temp;
    static int sum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sum = 0;

        for (int i = 1; i <= N; i++) {
            temp = i;

            while (temp > 0) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
                    sum++;
                }
                temp /= 10;
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
