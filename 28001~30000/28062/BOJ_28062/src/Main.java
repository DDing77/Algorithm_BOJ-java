import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer> oddList = new ArrayList<>();
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number % 2 == 0) {
                res += number;
            } else {
                oddList.add(number);
            }
        }

        oddList.sort(Collections.reverseOrder());
        if (oddList.size() % 2 == 1) {
            oddList.remove(oddList.size() - 1);
        }

        for (Integer number : oddList) {
            res += number;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
