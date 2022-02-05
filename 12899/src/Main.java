import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] Tree;

    static int update(int left, int right, int target, int value, int nodeNum) {
        if (target < left || target > right) return Tree[nodeNum];
        if (left == right) return Tree[nodeNum] += value;
        int mid = (left + right) / 2;
        return Tree[nodeNum] = update(left, mid, target, value, nodeNum * 2) + update(mid + 1, right, target, value, nodeNum * 2 + 1);
    }

    static int getQueryTD(int left, int right, int target, int nodeNum) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (Tree[nodeNum*2] >= target) return getQueryTD(left, mid, target, nodeNum * 2);
        else return getQueryTD(mid+1, right, target- Tree[nodeNum*2], nodeNum * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int startLeaf = 1;
        while (startLeaf < 2000000) {
            startLeaf *= 2;
        }
        int len = startLeaf * 2;
        Tree = new int[len + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int input = Integer.parseInt(st.nextToken());
                update(1, startLeaf, input, 1,1);
            } else {
                int target = Integer.parseInt(st.nextToken());
                int idx = getQueryTD(1, startLeaf, target, 1);
                sb.append(idx).append('\n');
                update(1, startLeaf, idx, -1,1);
            }
        }
        System.out.print(sb);
    }
}
