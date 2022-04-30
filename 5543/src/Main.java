import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int buger = Integer.MAX_VALUE;
    static int coke = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 3; i++) buger = Math.min(buger, Integer.parseInt(br.readLine()));
        for (int i = 1; i <= 2; i++) coke = Math.min(coke, Integer.parseInt(br.readLine()));

        int res = buger + coke - 50;
        System.out.println(res);
    }
}
