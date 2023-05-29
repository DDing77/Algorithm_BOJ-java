import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int use;
    static int left;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        use = Integer.parseInt(br.readLine());
        left = Integer.parseInt(br.readLine());

        int sum = left + 60;

        if (sum >= use) System.out.println(use * 1500);
        else System.out.println(sum * 1500 + (use - sum) * 3000);
    }
}