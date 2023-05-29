import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static double k;
    static double ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Double.parseDouble(br.readLine());

        ans = 25.0 + k * 0.01;
        if (ans <= 100) System.out.println("100.00");
        else if (ans >= 2000) System.out.println("2000.00");
        else System.out.println(String.format("%.2f", ans));
    }
}