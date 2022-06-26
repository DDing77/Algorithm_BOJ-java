import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int w1, h1;
    static int w2, h2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w1 = Integer.parseInt(br.readLine());
        h1 = Integer.parseInt(br.readLine());
        w2 = Integer.parseInt(br.readLine());
        h2 = Integer.parseInt(br.readLine());

        System.out.println(4 + 2 * Math.max(w1, w2) + 2 * (h1 + h2));
    }
}