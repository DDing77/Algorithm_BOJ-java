import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final HashMap<String, Character> wordMap = new HashMap<>();

    private int N;
    private String word;

    private void initWordMap() {

        wordMap.put("000000", 'A');
        wordMap.put("001111", 'B');
        wordMap.put("010011", 'C');
        wordMap.put("011100", 'D');
        wordMap.put("100110", 'E');
        wordMap.put("101001", 'F');
        wordMap.put("110101", 'G');
        wordMap.put("111010", 'H');
    }

    private int compareWord(String parent, String pattern) {

        int count = 0;
        for (int i = 0; i < parent.length(); i++) {
            if (parent.charAt(i) != pattern.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private void solution() throws IOException {

        initWordMap();
        N = Integer.parseInt(br.readLine());
        word = br.readLine();

        for (int i = 0; i < word.length(); i += 6) {
            String pattern = word.substring(i, i + 6);

            int minCount = Integer.MAX_VALUE;
            String findWord = "";
            for (Map.Entry<String, Character> entry : wordMap.entrySet()) {
                int count = compareWord(entry.getKey(), pattern);
                if (count < minCount) {
                    findWord = entry.getKey();
                    minCount = count;
                }
            }
            if (minCount > 1) {
                System.out.println((i + 6) / 6);
                return;
            }

            sb.append(wordMap.get(findWord));
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
