import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (input[i] - 3 < 'A') sb.append((char) (input[i] + 23));
            else sb.append((char) (input[i] - 3));
        }

        System.out.println(sb);
    }
}
