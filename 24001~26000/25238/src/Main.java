import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        final int defencePoint = Integer.parseInt(input[0]);
        final int defencePenetrationPercentage = Integer.parseInt(input[1]);

        boolean isDamage = true;
        if (defencePoint * (100 - defencePenetrationPercentage) >= 10000) {
            isDamage = false;
        }

        System.out.print(isDamage ? 1 : 0);
    }
}