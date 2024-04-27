import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int MAX_LENGTH = 101;
    private int N;
    private int K;
    private int[] order;
    private boolean[] in;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        in = new boolean[MAX_LENGTH];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < K; i++) {
            int cur = order[i];

            if (!in[cur]) {
                if (set.size() < N) {
                    set.add(cur);
                    in[cur] = true;
                } else {
                    ArrayList<Integer> nextUseList = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (in[order[j]] && !nextUseList.contains(order[j])) {
                            nextUseList.add(order[j]);
                        }
                    }
                    if (nextUseList.size() < N) {
                        for (int target : set) {
                            if (in[target] && !nextUseList.contains(target)) {
                                in[target] = false;
                                set.remove(target);
                                break;
                            }
                        }
                    } else {
                        int target = nextUseList.get(nextUseList.size() - 1);
                        set.remove(target);
                        in[target] = false;
                    }
                    in[cur] = true;
                    set.add(cur);
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
