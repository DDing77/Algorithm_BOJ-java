import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private int N;
    private boolean[] isVisited;
    private int[] numbers;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];

            if (i == numbers[i]) {
                isVisited[i] = true;
                list.add(i);
                continue;
            }

            if (!isVisited[i]) {
                isVisited[i] = true;
                int root = i;
                int next = numbers[root];

                while (!isVisited[next]) {
                    isVisited[next] = true;
                    next = numbers[next];
                }

                if (next == root) {
                    list.add(root);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append('\n');
        for (int e : list) {
            sb.append(e).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}