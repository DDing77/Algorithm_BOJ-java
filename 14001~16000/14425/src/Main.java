import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.childNode.get(c) == null) {
                    current.childNode.put(c, new TrieNode());
                }
                current = current.childNode.get(c);
            }
            current.isEnd = true;
        }
        boolean contain(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(current.childNode.get(c) == null){
                    return false;
                }
                current = current.childNode.get(c);
            }
            if(!current.isEnd) return false;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for(int i=0; i<N; i++) {
            trie.insert(br.readLine());
        }
        int cnt = 0;
        for(int i=0; i<M; i++) {
            if(trie.contain(br.readLine())){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
