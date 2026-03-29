import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < n; tc++) {
            String word = br.readLine();
            StringBuilder restored = new StringBuilder();

            int changedCount = 0;
            int i = 0;

            while (i < word.length()) {
                char ch = word.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    restored.append(ch);
                    i++;
                    continue;
                }

                if (ch == '@') {
                    restored.append('a');
                    changedCount++;
                    i++;
                } else if (ch == '[') {
                    restored.append('c');
                    changedCount++;
                    i++;
                } else if (ch == '!') {
                    restored.append('i');
                    changedCount++;
                    i++;
                } else if (ch == ';') {
                    restored.append('j');
                    changedCount++;
                    i++;
                } else if (ch == '^') {
                    restored.append('n');
                    changedCount++;
                    i++;
                } else if (ch == '0') {
                    restored.append('o');
                    changedCount++;
                    i++;
                } else if (ch == '7') {
                    restored.append('t');
                    changedCount++;
                    i++;
                } else if (ch == '\\') {
                    if (i + 2 < word.length()
                            && word.charAt(i + 1) == '\\'
                            && word.charAt(i + 2) == '\'') {
                        restored.append('w');
                        changedCount++;
                        i += 3;
                    } else if (i + 1 < word.length()
                            && word.charAt(i + 1) == '\'') {
                        restored.append('v');
                        changedCount++;
                        i += 2;
                    }
                }
            }

            int originalLength = restored.length();

            if (changedCount * 2 >= originalLength) {
                sb.append("I don't understand").append('\n');
            } else {
                sb.append(restored).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}