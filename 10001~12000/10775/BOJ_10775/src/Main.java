import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int G, P;
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

        parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        Arrays.fill(parent, -1);

        res = 0;
        for (int i = 0; i < P; i++) {
            int gate = find(Integer.parseInt(br.readLine()));
            if (gate == 0) break;

            res++;
            union(gate, gate - 1);
        }

        System.out.println(res);
    }
}
