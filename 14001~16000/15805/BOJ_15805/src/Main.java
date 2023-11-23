import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    final int MAX = 200_001;
    int N;
    Set<Integer> node;
    int[] parent;
    int[] number;

    public void solution() {
        StringBuilder sb = new StringBuilder();

        parent[number[0]] = -1;
        node.add(number[0]);
        for (int i = 1; i < N; i++) {
            if (node.contains(number[i])) {
                continue;
            }
            node.add(number[i]);
            parent[number[i]] = number[i - 1];
        }

        sb.append(node.size()).append('\n');
        for (int i = 0; i < node.size(); i++) {
            sb.append(parent[i]).append(" ");
        }

        System.out.println(sb);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        parent = new int[MAX];
        node = new HashSet<>();

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
