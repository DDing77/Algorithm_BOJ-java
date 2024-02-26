import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    Stack<Integer> temp;
    Stack<Integer> line;

    private void solution() throws IOException {

        temp = new Stack<>();
        line = new Stack<>();

        int order = 1;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (cur == order) {
                order++;
                continue;
            }

            if (temp.isEmpty()) {
                temp.add(cur);
                continue;
            }

            if (temp.peek() < cur) {
                if (temp.peek() != order) {
                    System.out.println("Sad");
                    return;
                }
            } else {
                temp.add(cur);
            }
        }

        System.out.println("Nice");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
