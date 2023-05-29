import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        area = Long.parseLong(br.readLine());

        double res = (double) Math.round(Math.sqrt(area * Math.PI) * 2 * 1000000000) / 1000000000;
        System.out.println(res);
    }
}