import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static double n;
    static double alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Double.parseDouble(br.readLine());
        alpha = Double.parseDouble(br.readLine());

        System.out.println((int) Math.round((180 - alpha) / 2 + alpha / 2));
    }
}