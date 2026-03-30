import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int LENGTH = 5;

    private int N;
    private HashMap<String, Integer> resultMap = new HashMap<>();
    private int G;
    private String hiddenWord;

    private String getResult(String hiddenWord, String curWord, StringBuilder tempSb) {
        for (int i = 0; i < LENGTH; i++) {
            boolean isFind = false;
            for (int j = 0; j < LENGTH; j++) {
                if (curWord.charAt(i) == hiddenWord.charAt(j)) {
                    isFind = true;
                    if (i == j) {
                        tempSb.append('*');
                    } else {
                        tempSb.append('!');
                    }
                    break;
                }
            }
            if (!isFind) {
                tempSb.append('X');
            }
        }
        return tempSb.toString();
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        hiddenWord = br.readLine();

        resultMap.put("*****", 1);
        StringBuilder tempSb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            String curWord = br.readLine();
            tempSb.setLength(0);
            String result = getResult(hiddenWord, curWord, tempSb);
            resultMap.put(result, resultMap.getOrDefault(result, 0) + 1);
        }

        G = Integer.parseInt(br.readLine());
        for (int i = 0; i < G; i++) {
            String feedbackStr = br.readLine();
            sb.append(resultMap.get(feedbackStr)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
