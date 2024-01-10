import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    final Set<String> promise = new HashSet<>();
    int N;

    private void init() {
        promise.add("Never gonna give you up");
        promise.add("Never gonna let you down");
        promise.add("Never gonna run around and desert you");
        promise.add("Never gonna make you cry");
        promise.add("Never gonna say goodbye");
        promise.add("Never gonna tell a lie and hurt you");
        promise.add("Never gonna stop");
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (!promise.contains(br.readLine())) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
