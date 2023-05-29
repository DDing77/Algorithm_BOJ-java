import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int MAX_LEAF = 30000;

    static class Info implements Comparable<Info> {
        int x;
        int y1;
        int y2;
        boolean left;

        public Info(int x, int y1, int y2, boolean left) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.left = left;
        }

        @Override
        public int compareTo(Info o) {
            return x - o.x;
        }
    }

    static ArrayList<Info> infos;
    static int[] cntTree;
    static int[] segTree;

    static void updateTD(int start, int end, int queryLeft, int queryRight, int value, int nodeNum) {
        if (queryLeft > end || queryRight < start) return;
        if (queryLeft <= start && end <= queryRight) cntTree[nodeNum] += value;
        else {
            int mid = (start + end) >> 1;
            updateTD(start, mid, queryLeft, queryRight, value, nodeNum * 2);
            updateTD(mid + 1, end, queryLeft, queryRight, value, nodeNum * 2 + 1);
        }

        if (cntTree[nodeNum] == 0) {
            if (start != end) segTree[nodeNum] = segTree[nodeNum * 2] + segTree[nodeNum * 2 + 1];
            else segTree[nodeNum] = 0;
        } else segTree[nodeNum] = end - start + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        infos = new ArrayList<>();

//        int startLeaf = 1;
//        while (startLeaf < N) startLeaf *= 2;
//        int length = startLeaf * 2;

        cntTree = new int[MAX_LEAF * 4];
        segTree = new int[MAX_LEAF * 4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            infos.add(new Info(x1, y1, y2, true));
            infos.add(new Info(x2, y1, y2, false));
        }

        Collections.sort(infos);

        int ans = 0;
        for (int i = 0; i < infos.size(); i++) {
            if (i != 0) ans += (infos.get(i).x - infos.get(i - 1).x) * segTree[1];

            int value = (infos.get(i).left == true) ? 1 : -1;
            updateTD(0, MAX_LEAF - 1, infos.get(i).y1, infos.get(i).y2 - 1, value, 1);
        }
        System.out.println(ans);
    }
}
