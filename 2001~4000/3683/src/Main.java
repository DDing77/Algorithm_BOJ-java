import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int c, d, v;
    static String[] v1;
    static String[] v2;
    static boolean[] isVisited;
    static ArrayList<Integer>[] edge;
    static int[] node;

    static boolean bMatching(int now) {
        for (int next : edge[now]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            if (node[next] == -1 || bMatching(node[next])) {
                node[next] = now;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            v1 = new String[v + 1];
            v2 = new String[v + 1];
            node = new int[v + 1];
            edge = new ArrayList[v + 1];

            for (int i = 0; i < v; i++) edge[i] = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                st = new StringTokenizer(br.readLine());
                v1[i] = st.nextToken();
                v2[i] = st.nextToken();
            }

            for (int i = 0; i < v - 1; i++) {
                for (int j = i + 1; j < v; j++) {
                    if (v1[i].compareTo(v2[j]) == 0 || v1[j].compareTo(v2[i]) == 0) {
                        if (v1[i].charAt(0) == 'C') edge[i].add(j);
                        else edge[j].add(i);
                    }
                }
            }

            Arrays.fill(node, -1);
            int cnt = 0;
            for (int i = 0; i < v; i++) {
                isVisited = new boolean[v + 1];
                if (bMatching(i)) {
                    cnt++;
                }
            }
            sb.append(v - cnt).append('\n');
        }
        System.out.print(sb);
    }
}
