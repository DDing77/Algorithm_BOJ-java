import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int resMaxLength;
    private String resWord;

    private Pattern pattern = Pattern.compile("[A-Za-z-]+");

    private void solution() throws IOException {
        while (true) {
            String line = br.readLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String word = matcher.group();

                if (word.equals("E-N-D")) {
                    System.out.println(resWord.toLowerCase());
                    return;
                }

                if (word.length() > resMaxLength) {
                    resMaxLength = word.length();
                    resWord = word;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
