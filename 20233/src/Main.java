import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        int firstOptionFee = a + ((T > 30 ? T : 30) - 30) * x * 21;

        int secondOptionFee = b + ((T > 45 ? T : 45) - 45) * y * 21;

        System.out.print(firstOptionFee + " " + secondOptionFee);
    }
}