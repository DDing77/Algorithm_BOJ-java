import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    char[] preorder;
    char[] inorder;

    private void searchPostorder(int preRootIdx, int left, int right) {
        if (preRootIdx == preorder.length) {
            return;
        }

        char inRootNode = preorder[preRootIdx];

        for (int i = left; i <= right; i++) {
            if (inorder[i] == inRootNode) {
                searchPostorder(preRootIdx + 1, left, i - 1);
                searchPostorder(preRootIdx + (i - left + 1), i + 1, right);
                sb.append(inRootNode);
                return;
            }
        }
    }

    private void solution() throws IOException {

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            preorder = st.nextToken().toCharArray();
            inorder = st.nextToken().toCharArray();

            searchPostorder(0, 0, inorder.length - 1);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
