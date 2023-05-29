import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] Node;
    static int[] maxTree;
    static int[] minTree;
    static int N, M;

    static int initMax(int left, int right, int nodeNum) {
        if (left == right) {
            return maxTree[nodeNum] = Node[nodeNum];
        }
        int mid = (left + right) / 2;
        return maxTree[nodeNum] = Math.max(initMax(left, mid, nodeNum * 2), initMax(mid + 1, right, nodeNum * 2 + 1));
    }

    static int initMin(int left, int right, int nodeNum) {
        if (left == right) {
            return minTree[nodeNum] = Node[nodeNum];
        }
//        minTree[nodeNum] = Integer.MAX_VALUE;
        int mid = (left + right) / 2;
        return minTree[nodeNum] = Math.min(initMin(left, mid, nodeNum * 2), initMin(mid + 1, right, nodeNum * 2 + 1));
    }

    static int maxQueryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < left || queryLeft > right) return Integer.MIN_VALUE;
        if (queryLeft <= left && right <= queryRight) return maxTree[nodeNum];
        int mid = (left + right) / 2;
        return Math.max(maxQueryTD(left, mid, queryLeft, queryRight, nodeNum*2), maxQueryTD(mid+1, right, queryLeft,queryRight, nodeNum*2+1));
    }

    static int minQueryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < left || queryLeft > right) return Integer.MAX_VALUE;
        if (queryLeft <= left && right <= queryRight) return minTree[nodeNum];
        int mid = (left + right) / 2;
        return Math.min(minQueryTD(left, mid, queryLeft, queryRight, nodeNum*2), minQueryTD(mid+1, right, queryLeft,queryRight, nodeNum*2+1));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int len = startLeaf * 2;
        Node = new int[len + 1];
        maxTree = new int[len + 1];
        minTree = new int[len + 1];

        for (int i = 0; i < N; i++) {
            Node[startLeaf + i] = Integer.parseInt(br.readLine());
        }
        initMax(1, startLeaf, 1);
        initMin(1, startLeaf, 1);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int queryLeft = Integer.parseInt(st.nextToken());
            int queryRight = Integer.parseInt(st.nextToken());
            sb.append(minQueryTD(1,startLeaf,queryLeft,queryRight,1)).append(' ');
            sb.append(maxQueryTD(1,startLeaf,queryLeft,queryRight,1)).append('\n');
        }
//        System.out.println(Arrays.toString(maxTree));
//        System.out.println(Arrays.toString(minTree));
        System.out.println(sb);
//        System.out.println(startLeaf);
//        System.out.println(len);
    }
}
