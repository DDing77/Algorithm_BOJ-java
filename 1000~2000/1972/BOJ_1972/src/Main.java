import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final String MESSAGE_1 = " is surprising.";
    private static final String MESSAGE_2 = " is NOT surprising.";
    private static final StringBuilder temp = new StringBuilder();
    private static final HashSet<String> set = new HashSet<>();

    private void solution() throws IOException {
        while (true) {
            String input = br.readLine();
            if (input.equals("*")) {
                break;
            }


            if (input.length() < 3) {
                sb.append(input).append(MESSAGE_1).append("\n");
            } else {
                boolean flag = true;
                for (int i = 1; i < input.length(); i++) {
                    set.clear();
                    if (!flag) {
                        break;
                    }
                    for (int j = 0; j < input.length() - i; j++) {
                        temp.setLength(0);
                        temp.append(input.charAt(j)).append(input.charAt(j + i));
                        if (set.contains(temp.toString())) {
                            sb.append(input).append(MESSAGE_2).append("\n");
                            flag = false;
                            break;
                        } else {
                            set.add(temp.toString());
                        }
                    }
                }
                if (flag) {
                    sb.append(input).append(MESSAGE_1).append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
