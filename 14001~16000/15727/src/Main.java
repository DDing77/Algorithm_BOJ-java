import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int q = N / 5;
        int r = N % 5;
        if (r != 0) System.out.println(q + 1);
        else System.out.println(q);


    }
}
