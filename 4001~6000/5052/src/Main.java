import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int T, n;

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        boolean insert(String word) {
            TrieNode current = this.root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(current.childNode.get(c) == null) {
                    current.childNode.put(c, new TrieNode());
                }
                current = current.childNode.get(c);
                if(current.isEnd) return false;
            }
            current.isEnd = true;
            if(current.childNode.size() != 0) return false;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            boolean flag = true;
            for(int i=0; i<n; i++) {
                if(!trie.insert(br.readLine())) flag = false;
            }
            sb.append(flag == true ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}
