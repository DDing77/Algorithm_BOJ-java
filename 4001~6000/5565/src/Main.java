import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        total = Integer.parseInt(br.readLine());

        for (int i = 0; i < 9; i++) {
            total -= Integer.parseInt(br.readLine());
        }

        System.out.println(total);
    }
}