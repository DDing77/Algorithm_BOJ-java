import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// author : DDing
// solution : Trie
// tip : DFS로 출력

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String[] word) {
            TrieNode current = root;
            for (String s : word) {
                if (current.children.get(s) == null) {
                    current.children.put(s, new TrieNode());
                }
                current = current.children.get(s);
            }
            current.isEnd = true;
        }

        void print(TrieNode currentNode, int depth) {
            for (String key : currentNode.children.keySet()) {
                for (int i = 0; i < depth; i++) sb.append(" ");
                sb.append(key).append('\n');
                print(currentNode.children.get(key), depth + 1);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("\\\\");
            trie.insert(str);
        }

        TrieNode current = trie.root;
        trie.print(current, 0);
        System.out.print(sb);
    }
}
