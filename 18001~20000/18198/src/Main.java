import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int aScore;
    static int bScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        aScore = 0;
        bScore = 0;

        for (int i = 0; i < input.length(); i += 2) {
            if (input.charAt(i) == 'A') {
                aScore += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            } else {
                bScore += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            }
        }

        if (aScore > bScore) System.out.println("A");
        else System.out.println("B");
    }
}
