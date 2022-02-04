import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] Node;

    static long initTD(int left, int right, int nodeNum) {
        if (left == right) return Node[nodeNum];
        int mid = (left + right) / 2;
        long A = initTD(left, mid, nodeNum * 2);
        long B = initTD(mid + 1, right, nodeNum * 2 + 1);
        Node[nodeNum] = A * B%1000000007;
        return Node[nodeNum];
    }

    static long queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > right || queryRight < left) return 1;
        else if (queryLeft <= left && right <= queryRight) return Node[nodeNum];
        int mid = (left + right) / 2;
        long A = queryTD(left, mid, queryLeft, queryRight, nodeNum * 2);
        long B = queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);
        return A * B%1000000007;
    }
    static long updateBU(int left, int right, int idx, long value, int nodeNum) {
        if(idx <left || idx > right) return Node[nodeNum];
        if(left == right) return Node[nodeNum]= value;
        int mid = (left+right) /2;
        return Node[nodeNum] = updateBU(left, mid, idx, value, nodeNum*2) *updateBU(mid+1, right, idx, value,nodeNum*2+1)%1000000007;
    }
    static void updateTd(int left, int right, int target, long rowValue, long next, int nodeNum) {
        if (target < left || target > right) return;
        if(rowValue != 0) {
            Node[nodeNum] /= rowValue;
            Node[nodeNum] *= next;
            if (left != right) {
                int mid = (left + right) / 2;
                updateTd(left, mid, target, rowValue, next, nodeNum * 2);
                updateTd(mid + 1, right, target, rowValue, next, nodeNum * 2 + 1);
            }
        } else {
            Node[nodeNum] += next;
            if (left != right) {
                int mid = (left + right) / 2;
                updateTd(left, mid, target, rowValue, next, nodeNum * 2);
                updateTd(mid + 1, right, target, rowValue, next, nodeNum * 2 + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int startLeaf = 1;
        while (startLeaf < N) {
            startLeaf *= 2;
        }
        int len = startLeaf * 2;
        Node = new long[len + 1];
        for(int i=0; i<=len; i++) {
            Node[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            Node[startLeaf + i] = Long.parseLong(br.readLine());
        }
        initTD(1, startLeaf, 1);
        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int index = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                updateBU(1, startLeaf, index,value, 1);
//                updateTd(1,startLeaf,index, Node[startLeaf+index-1], value,1);
            } else {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                sb.append(queryTD(1,startLeaf,queryLeft,queryRight,1)).append('\n');
            }
        }
//        System.out.println(Arrays.toString(Node));
        System.out.print(sb);
    }
}
