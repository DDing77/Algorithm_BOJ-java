import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int res = 0;

        for (int i = 0; i < input.length(); i++) {
            double cur = Double.parseDouble(String.valueOf(input.charAt(i)));
            res += Math.pow(cur, 5);
        }
        System.out.println(res);
    }
}
