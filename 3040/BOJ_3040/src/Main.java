import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private int[] numbers;
    private int res;
    private StringBuilder sb;
    private boolean[] isVisited;

    public void DFS(boolean[] isVisited, int sum, int idx, int depth) {
        if (sum == 100 && depth == 7) {
            for (int i = 0; i < isVisited.length; i++) {
                if (isVisited[i]) {
                    sb.append(numbers[i]).append('\n');
                }
            }
            return;
        }

        for (int i = idx; i <= 9; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                DFS(isVisited, sum + numbers[i], i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        isVisited = new boolean[10];
        numbers = new int[10];
        for (int i = 1; i <= 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        DFS(isVisited, 0, 1, 0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
