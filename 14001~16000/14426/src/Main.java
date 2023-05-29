import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// author : DDing
// solution : Trie

public class Main {
    static int cnt =0;
    static int N, M;
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }
    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(current.children.get(c) == null) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.isEnd = true;
        }
        boolean contain(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(current.children.get(c) == null) return false;
                current = current.children.get(c);
            }
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        for(int i=0; i<N; i++) trie.insert(br.readLine());
        for(int i=0; i<M; i++) {
            if(trie.contain(br.readLine())) cnt++;
        }
        System.out.println(cnt);
    }
}
