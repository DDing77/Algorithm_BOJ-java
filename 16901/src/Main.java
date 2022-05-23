import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;
    static int[] a;
    static class Node {
        int l;
        int r;
        public Node() {
            this.l = -1;
            this.r = -1;
        }
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static ArrayList<Node> nodes;

    static void insert(int x, int node, int depth) {
        if(depth == -1 ) return;
        if(((x >> depth) & 1) > 0) {
            if(nodes.get(node).r == -1) {
                nodes.get(node).r = nodes.size();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
