import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        if (R * 8 + S * 3 - 28 < 0) System.out.println(0);
        else System.out.println(R * 8 + S * 3 - 28);
    }
}
