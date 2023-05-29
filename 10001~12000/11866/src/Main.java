import java.io.*;
import java.util.*;

public class Main { //BOJ_11866
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int index = K;

        for (int i = 0; i < N; i++) queue.add(i + 1);
        System.out.print("<");
        while (queue.size() != 1) {
            System.out.print(queue.get(index) + ", ");
            queue.remove(index);
            index = (index + K) % queue.size();
        }
        System.out.print(queue.poll() + ">");
    }
}
