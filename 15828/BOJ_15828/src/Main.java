import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static Queue<Integer> que;
    static int input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        que = new LinkedList<>();


        while (true) {
            input = Integer.parseInt(br.readLine());
            if (input == -1) break;
            if (input == 0) {
                que.poll();
                continue;
            }
            if (que.size() < N) {
                que.add(input);
            }
        }

        if (que.isEmpty()) {
            System.out.println("empty");
            return;
        }

        while (!que.isEmpty()) {
            sb.append(que.poll() + " ");
        }

        System.out.print(sb);
    }
}
