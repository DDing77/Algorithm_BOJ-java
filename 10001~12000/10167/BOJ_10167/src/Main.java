import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private List<Mine> mines;
    private List<Mine>[] yLines;
    private Node[] nodeTree;
    private long res;

    private Node update(int start, int end, int idx, int value, int nodeNum) {
        if (idx > end || idx < start) {
            return nodeTree[nodeNum];
        }

        if (start == end) {
            nodeTree[nodeNum].leftMax += value;
            nodeTree[nodeNum].rightMax += value;
            nodeTree[nodeNum].total += value;
            nodeTree[nodeNum].subMax += value;
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        Node leftNode = update(start, mid, idx, value, nodeNum * 2);
        Node rightNode = update(mid + 1, end, idx, value, nodeNum * 2 + 1);

        nodeTree[nodeNum].leftMax = Math.max(leftNode.leftMax, leftNode.total + rightNode.leftMax);
        nodeTree[nodeNum].rightMax = Math.max(rightNode.rightMax, rightNode.total + leftNode.rightMax);
        nodeTree[nodeNum].total = leftNode.total + rightNode.total;
        nodeTree[nodeNum].subMax = Math.max(leftNode.rightMax + rightNode.leftMax, Math.max(leftNode.subMax, rightNode.subMax));
        return nodeTree[nodeNum];
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        mines = new ArrayList<Mine>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mines.add(new Mine(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(mines, Comparator.comparingInt(a -> a.x));

        int cnt = 0;
        int[] sparseCnt = new int[N];
        for (int i = 1; i < N; i++) {
            if (mines.get(i - 1).x != mines.get(i).x) {
                cnt++;
            }
            sparseCnt[i] = cnt;
        }

        for (int i = 0; i < N; i++) {
            mines.get(i).x = sparseCnt[i];
        }

        Collections.sort(mines, Comparator.comparingInt(a -> a.y));
        cnt = 0;
        for (int i = 1; i < N; i++) {
            if (mines.get(i - 1).y != mines.get(i).y) {
                cnt++;
            }
            sparseCnt[i] = cnt;
        }

        for (int i = 0; i < N; i++) {
            mines.get(i).y = sparseCnt[i];
        }

//        for (Mine mine : mines) {
//            System.out.println("x = " + mine.x + " y = " + mine.y);
//        }

        yLines = new List[N];
        for (int i = 0; i < N; i++) {
            yLines[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            yLines[mines.get(i).y].add(mines.get(i));
        }

        for (int top = 0; top < N; top++) {
            nodeTree = new Node[N * 4];
            for (int i = 0; i < nodeTree.length; i++) {
                nodeTree[i] = new Node();
            }
            for (int bottom = top; bottom < N; bottom++) {
                for (Mine mine : yLines[bottom]) {
                    update(0, N - 1, mine.x, mine.w, 1);
                }
                res = Math.max(res, nodeTree[1].subMax);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Mine {

        int x;
        int y;
        int w;

        public Mine(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static class Node {

        long leftMax;
        long rightMax;
        long total;
        long subMax;
    }
}
