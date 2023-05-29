import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int startLeaf;
    static int[] Node;
    static StringBuilder sb = new StringBuilder();

    static void updateTD(int left, int right, int targetNode, int nodeNum, int diff) {
        if (targetNode < left || targetNode > right) return;

        Node[nodeNum] += diff;

        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        updateTD(left, mid, targetNode, nodeNum * 2, diff);
        updateTD(mid + 1, right, targetNode, nodeNum * 2 + 1, diff);
    }

    static void queryTD(int left, int right, int rank, int nodeNum) {
        if (left == right) {
            updateTD(1, startLeaf, nodeNum - startLeaf + 1, 1, -1);
            sb.append(left).append('\n');
            return;
        }
        int mid = (left + right) / 2;
        if (Node[nodeNum * 2] >= rank) {
            queryTD(left, mid, rank, nodeNum * 2);
        } else {
            queryTD(mid + 1, right, rank - Node[nodeNum * 2], nodeNum * 2 + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        startLeaf = 1;
        while (startLeaf < 1000000) startLeaf *= 2;
        int len = startLeaf * 2;

        Node = new int[len + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 2) {
                int targetNode = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                updateTD(1, startLeaf, targetNode, 1, value);
            } else {
                int rank = Integer.parseInt(st.nextToken());
                queryTD(1, startLeaf, rank, 1);
            }
        }
        System.out.println(sb);
    }
}
