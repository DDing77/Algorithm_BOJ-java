import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (this.value > value) {
                if (this.left == null) this.left = new Node(value);
                else this.left.insert(value);
            } else {
                if (this.right == null) this.right = new Node(value);
                else this.right.insert(value);
            }
        }
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.value).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            int number = Integer.parseInt(input);

            root.insert(number);
        }
        postOrder(root);

        System.out.print(sb);
    }
}
