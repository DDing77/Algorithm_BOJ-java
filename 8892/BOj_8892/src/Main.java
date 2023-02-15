import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T, k;
    static String[] input;

    public static boolean isPalindrome(String temp) {
        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - i - 1)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            input = new String[k];
            for (int i = 0; i < k; i++) {
                input[i] = br.readLine();
            }

            boolean flag = false;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i == j) continue;
                    String temp = input[i].concat(input[j]);

                    if (isPalindrome(temp)) {
                        sb.append(temp).append('\n');
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                sb.append("0").append('\n');
            }
        }
        System.out.print(sb);
    }
}
