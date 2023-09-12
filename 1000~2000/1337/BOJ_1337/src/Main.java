import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    int N;
    ArrayList<Integer> numbers;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numbers);

        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = numbers.get(i); j < numbers.get(i) + 5; j++) {
                if (!numbers.contains(j)) {
                    cnt++;
                }
            }

            res = Math.min(res, cnt);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
