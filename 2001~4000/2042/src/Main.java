import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] Node;
    static int startLeaf;

    static long initTD(int left, int right, int nodeNum) {
        if (left == right) {
            return Node[nodeNum];
        }
        int mid = (left + right) / 2;
        long A = initTD(left, mid, nodeNum * 2);
        long B = initTD(mid + 1, right, nodeNum * 2 + 1);
        Node[nodeNum] = A + B;
        return Node[nodeNum];
    }

    static long queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < left || queryLeft > right) return 0;
        else if (queryLeft <= left && right <= queryRight) {
            return Node[nodeNum];
        }
        int mid = (left + right) / 2;
        long A = queryTD(left, mid, queryLeft, queryRight, nodeNum * 2);
        long B = queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);
        return A + B;
    }

    static void updateTD(int left, int right, int target, long diff,int nodeNum) {
        if(  target <left || target> right) return;
        Node[nodeNum] += diff;
        if(left != right) {
            int mid = (left + right) /2;
            updateTD(left, mid, target, diff, nodeNum*2);
            updateTD(mid + 1, right, target, diff, nodeNum*2+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int len = 1;
        while (len < N) { // 초기 startLeaf 길이 구하기
            len = len * 2;
        }
        startLeaf = len;
        len *= 2;
//        System.out.println(startLeaf);
//        System.out.println(len);
        Node = new long[len + 1];
        for (int i = 0; i < N; i++) {
            Node[startLeaf + i] = Long.parseLong(br.readLine());
        }

        initTD(1, startLeaf, 1);

        for(int i=0; i<M +K; i++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int index = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                long diff = value - Node[startLeaf + index -1];
                updateTD(1, startLeaf, index, diff,1 );
            }
            else {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                sb.append(queryTD(1,startLeaf, queryLeft, queryRight,1)).append('\n');
            }
        }
        System.out.println(sb);

    }
}
