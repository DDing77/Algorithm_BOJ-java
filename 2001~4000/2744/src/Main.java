import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 'a') sb.append((char) (input.charAt(i) + 32));
            else sb.append((char) (input.charAt(i) - 32));
        }

        System.out.println(sb);
    }
}
