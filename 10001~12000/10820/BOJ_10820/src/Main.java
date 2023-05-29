import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while ((input = br.readLine()) != null) {
            sb = new StringBuilder();
            res = new int[4];
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if ('0' <= cur && cur <= '9') res[2]++;
                else if ('a' <= cur && cur <= 'z') res[0]++;
                else if ('A' <= cur && cur <= 'Z') res[1]++;
                else res[3]++;
            }

            sb.append(res[0] + " ")
                    .append(res[1] + " ")
                    .append(res[2] + " ")
                    .append(res[3] + " ")
                    .append('\n');

            System.out.print(sb);
        }
    }
}