import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    int N;
    ArrayList<Integer> numbers;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        for (int i = 3; i <= N - 6; i += 3) {
            numbers.add(i);
        }

        res = 0;
        for (int first : numbers) {
            for (int second : numbers) {
                int third = N - first - second;
                if (third % 3 == 0 && third > 0) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
