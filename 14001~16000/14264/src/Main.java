import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double N = Double.parseDouble(br.readLine());

        double res = Math.pow(N, 2) * Math.sqrt(3) / 4;
        System.out.println(res);
    }
}
