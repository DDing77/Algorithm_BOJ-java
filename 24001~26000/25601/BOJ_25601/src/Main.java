import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int idx = 0;
    private HashMap<String, Integer> hashTable = new HashMap<>();
    private int[] edges;

    private boolean search(int start, int target) {
        int cur = start;
        int next = -1;
        while (edges[cur] != -1) {
            next = edges[cur];
            if (next == target) {
                return true;
            }
            cur = next;
        }
        return false;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        edges = new int[N];
        Arrays.fill(edges, -1);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String childStr = st.nextToken();
            String parentStr = st.nextToken();

            if (!hashTable.containsKey(childStr)) {
                hashTable.put(childStr, idx++);
            }

            if (!hashTable.containsKey(parentStr)) {
                hashTable.put(parentStr, idx++);
            }

            int childIdx = hashTable.get(childStr);
            int parentIdx = hashTable.get(parentStr);
            edges[childIdx] = parentIdx;
        }

        st = new StringTokenizer(br.readLine());
        int start = hashTable.get(st.nextToken());
        int target = hashTable.get(st.nextToken());

        if (search(start, target) || search(target, start)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
