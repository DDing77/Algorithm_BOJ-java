import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer>[] hates;
    private ArrayList<Integer> blues;
    private ArrayList<Integer> whites;
    private Queue<Integer> que;

    private void execDFS(boolean isBlue, int cur) {
        if (isBlue) {
            blues.add(cur);
        } else {
            whites.add(cur);
        }

        for (int hate : hates[cur]) {
            if (que.contains(hate)) {
                que.remove(hate);
                execDFS(!isBlue, hate);
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        hates = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            hates[i] = new ArrayList<>();
        }

        que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                hates[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        blues = new ArrayList<>();
        whites = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.poll();
            execDFS(true, cur);
        }

        Collections.sort(blues);
        sb.append(blues.size()).append("\n");
        for (Integer blue : blues) {
            sb.append(blue).append(" ");
        }
        sb.append("\n");

        Collections.sort(whites);
        sb.append(whites.size()).append("\n");
        for (Integer white : whites) {
            sb.append(white).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
