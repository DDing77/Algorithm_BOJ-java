import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int know;
    static List<Integer> truePeople;
    static ArrayList<Integer>[] groups;
    static int[] parent;
    static int res;

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) return;

        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        truePeople = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        know = Integer.parseInt(st.nextToken());
        while (know-- > 0) truePeople.add(Integer.parseInt(st.nextToken()));

        groups = new ArrayList[M];
        for (int i = 0; i < M; i++) groups[i] = new ArrayList<>();

        int pre = 0;
        int cur;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int memberN = Integer.parseInt(st.nextToken());
            if (memberN > 0) {
                pre = Integer.parseInt(st.nextToken());
                groups[i].add(pre);
            }
            for (int j = 1; j < memberN; j++) {
                cur = Integer.parseInt(st.nextToken());
                groups[i].add(cur);
                union(pre, cur);
                pre = cur;
            }
        }

        res = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int num : truePeople) {
                if (find(num) == find(groups[i].get(0))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) res++;
        }

        System.out.println(res);
    }
}

