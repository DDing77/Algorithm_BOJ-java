import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        input = br.readLine();

        long temp;
        res = 0;
        while (input.length() > 1) {
            temp = 0;
            for (int i = 0; i < input.length(); i++) {
                temp += Integer.parseInt(input.substring(i, i + 1));
            }
            input = String.valueOf(temp);
            res++;
        }
        sb.append(res).append('\n');
        if (Integer.parseInt(input) % 3 == 0) sb.append("YES");
        else sb.append("NO");

        System.out.println(sb);

    }
}
