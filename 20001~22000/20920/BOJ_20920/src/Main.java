import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    HashMap<String, Integer> hashMap;
    ArrayList<Word> words;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() < M) {
                continue;
            }

            hashMap.put(input, hashMap.getOrDefault(input, 0) + 1);
        }

        words = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            words.add(new Word(s, hashMap.get(s)));
        }

        Collections.sort(words);

        for (Word word : words) {
            sb.append(word.spelling).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Word implements Comparable<Word> {
        String spelling;
        int cnt;

        public Word(String spelling, int cnt) {
            this.spelling = spelling;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt == o.cnt) {
                if (this.spelling.length() == o.spelling.length()) {
                    return this.spelling.compareTo(o.spelling);
                }
                return Integer.compare(o.spelling.length(), this.spelling.length());
            }
            return Integer.compare(o.cnt, this.cnt);
        }
    }
}
