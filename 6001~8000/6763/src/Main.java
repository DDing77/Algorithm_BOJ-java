import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int limit = Integer.parseInt(br.readLine());
        int recorded = Integer.parseInt(br.readLine());

        int diff = recorded - limit;
        if (diff <= 0) System.out.println("Congratulations, you are within the speed limit!");
        else {
            sb.append("You are speeding and your fine is ");
            if (diff > 30) sb.append("$" + 500 + ".");
            else if (diff > 20) sb.append("$" + 270 + ".");
            else sb.append("$" + 100 + ".");
        }
        System.out.println(sb);
    }
}
