import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int x, y, z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());
        z = Integer.parseInt(br.readLine());

        if (x + y <= z + 0.5) System.out.println(1);
        else System.out.println(0);
    }
}