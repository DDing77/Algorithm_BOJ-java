import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N;
    static Stack<Integer> builds;
    static long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        builds = new Stack<>();

        res = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            while (!builds.isEmpty() && cur >= builds.peek()) {
                builds.pop();
            }

            builds.push(cur);

            res += builds.size() - 1;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
