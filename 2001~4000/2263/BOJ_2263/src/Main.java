import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int n;
    int[] inOrder;
    int[] postOrder;
    int[] position;
    int root;
    StringBuilder sb;

    public void getOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        root = postOrder[postEnd];
        sb.append(root + " ");

        int inRoot = position[root];
        int left = inRoot - inStart;

        getOrder(inStart, inRoot - 1, postStart, postStart + left - 1);
        getOrder(inRoot + 1, inEnd, postStart + left, postEnd - 1);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        inOrder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        postOrder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        position = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            position[inOrder[i]] = i;
        }

        getOrder(1, n, 1, n);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
