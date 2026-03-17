import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }

            StringBuilder sb1 = new StringBuilder();
            int idx = 0;
            char[] chArr = input.toCharArray();
            while (idx < chArr.length) {
                if (chArr[idx] == 'a' ||
                        chArr[idx] == 'e' ||
                        chArr[idx] == 'i' ||
                        chArr[idx] == 'o' ||
                        chArr[idx] == 'u') {
                    break;
                }
                sb1.append(chArr[idx++]);
            }

            StringBuilder sb2 = new StringBuilder();
            while (idx < chArr.length) {
                sb2.append(chArr[idx++]);
            }
            sb.append(sb2.toString() + sb1.toString() + "ay").append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
