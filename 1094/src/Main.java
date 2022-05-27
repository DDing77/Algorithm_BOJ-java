import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        int res = 0;

        for (int i = 0; i <= 6; i++) if ((X & 1 << i) > 0) res++;
        System.out.println(res);
    }
}
