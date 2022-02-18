import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static StringBuilder sb = new StringBuilder();

    static class TrieNode {
        Map<String, TrieNode> childNode = new TreeMap<>();
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String[] word) {
            TrieNode current = root;
            int cnt = 0;
//            System.out.println(word[0]);
//            System.out.println(word[1]);
            for (String str : word) {
//                System.out.println(str);

                if (current.childNode.get(str) == null) {
                    current.childNode.put(str, new TrieNode());
                }
                current = current.childNode.get(str);
            }
            current.isEnd = true;
        }

        // dfs
        void print(TrieNode currentNode, int depth) {
            for (String s : currentNode.childNode.keySet()) {
                for (int i = 0; i < depth; i++) sb.append("--");
                sb.append(s).append("\n");
                print(currentNode.childNode.get(s), depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            String[] str = new String[K];
            for (int j = 0; j < K; j++) {
                str[j] = st.nextToken();
            }
            trie.insert(str);
        }
        TrieNode current = trie.root;
        trie.print(current, 0);
        System.out.println(sb);
    }
}
