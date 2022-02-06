import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value;
        int min;
        int max;

        public Node(int value, int min, int max) {
            this.value = value;
            this.min = min;
            this.max = max;
        }
    }

    static Node[] nodes;
    static int[] arr;
    static int T, N, K;

    static Node initTD(int left, int right, int nodeNum) {
        if (left == right) {
            arr[left] = left;
            nodes[nodeNum].max = nodes[nodeNum].min = arr[left];
            return nodes[nodeNum];
        }
        int mid = (left + right) / 2;
        Node y = initTD(left, mid, nodeNum*2+1);
        Node x = initTD(mid+1, right, nodeNum*2+2);
        nodes[nodeNum].max = Math.max(y.max, x.max);
        nodes[nodeNum].min = Math.min(y.min, x.min);
//        nodes[nodeNum].max = Math.max(initTD(left, mid, nodeNum * 2 + 1).max, initTD(mid + 1, right, nodeNum * 2 + 2).max);
//        nodes[nodeNum].min = Math.min(initTD(left, mid, nodeNum * 2 + 1).min, initTD(mid + 1, right, nodeNum * 2 + 2).min);
        return nodes[nodeNum];
    }

    static boolean queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > right || left > queryRight) return true;
        if (queryLeft <= left && right <= queryRight) {
            return queryLeft <= nodes[nodeNum].min && nodes[nodeNum].max <= queryRight;
        }
        int mid = (left + right) / 2;
        return queryTD(left, mid, queryLeft, queryRight, nodeNum * 2 + 1) && queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 2);
    }

    static Node updateTD(int left, int right, int target, int value, int nodeNum) {
        if (target < left || target > right) return nodes[nodeNum];
        nodes[nodeNum].max = Math.max(nodes[nodeNum].max, value);
        nodes[nodeNum].min = Math.min(nodes[nodeNum].min, value);

        if (left == right) {
            nodes[nodeNum].min = value;
            nodes[nodeNum].max = value;
            nodes[nodeNum].value = value;
            arr[target] = value;
            return nodes[nodeNum];
        }
        int mid = (left + right) / 2;
        Node y = updateTD(left, mid, target, value, nodeNum*2+1);
        Node x = updateTD(mid+1, right, target, value, nodeNum*2+2);
        nodes[nodeNum].max = Math.max(y.max, x.max);
        nodes[nodeNum].min = Math.min(y.min, x.min);
//        nodes[nodeNum].max = Math.max(updateTD(left, right, target, value, nodeNum * 2 + 1).max, updateTD(mid + 1, right, target, value, nodeNum * 2 + 2).max);
//        nodes[nodeNum].min = Math.min(updateTD(left, right, target, value, nodeNum * 2 + 1).min, updateTD(mid + 1, right, target, value, nodeNum * 2 + 2).min);
        return nodes[nodeNum];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int startLeaf = 1;
            while (startLeaf < N) startLeaf *= 2;
            int len = startLeaf * 2;
            arr = new int[ 100001*4];
            nodes = new Node[100001*4];
            for (int i = 0; i < 100001*4; i++) {
                arr[i] = i;
                nodes[i] = new Node(i, i, i);
            }
            initTD(0,N-1,0);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int Q = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                if (Q == 1) { // 가져오는 쿼리
                    if(queryTD(0,N-1,A,B,0)) sb.append("YES\n");
                    else sb.append("NO\n");

                } else { // 변경하는 쿼리
                    int temp = arr[A];
                    updateTD(0, N-1, A, arr[B],0);
                    updateTD(0, N-1, B, temp, 0);
                }
            }

        }
        System.out.println(sb);
    }
}
