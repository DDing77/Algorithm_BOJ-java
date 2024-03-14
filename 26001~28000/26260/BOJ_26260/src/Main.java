import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] nodes;

    private void searchPostorder(int left, int right) {

        if (left > right) {
            return;
        }

        int midIdx = (left + right) >> 1;

        searchPostorder(left, midIdx - 1);
        searchPostorder(midIdx + 1, right);
        sb.append(nodes[midIdx]).append(" ");
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        nodes = new int[N];

        int toChangeIdx = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
            if (nodes[i] == -1) {
                toChangeIdx = i;
            }
        }

        nodes[toChangeIdx] = Integer.parseInt(br.readLine());

        Arrays.sort(nodes);
        searchPostorder(0, N - 1);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
