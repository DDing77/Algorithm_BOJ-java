import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        que = new LinkedList<>();
        for (int i = 1; i <= N; i++) que.add(i);

        while (que.size() > 1) {
            sb.append(que.poll()).append(" ");
            que.add(que.poll());
        }

        sb.append(que.poll());
        System.out.println(sb);
    }
}
