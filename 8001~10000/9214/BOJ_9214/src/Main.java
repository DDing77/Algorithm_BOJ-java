import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int tc = 1;
    private String str;

    private void solution() throws IOException {
        while (true) {
            str = br.readLine();
            if (str.equals("0")) {
                break;
            }

            StringBuilder temp = new StringBuilder();
            while (str.length() > 1) {
                if (str.length() % 2 == 1) {
                    break;
                }

                temp.setLength(0);
                for (int i = 0; i < str.length(); i += 2) {
                    for (int j = 0; j < str.charAt(i) - '0'; j++) {
                        temp.append(str.charAt(i + 1));
                    }
                }

                if (str.equals(temp.toString())) {
                    str = temp.toString();
                    break;
                }

                str = temp.toString();
            }

            sb.append("Test ").append(tc++).append(": ");
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
