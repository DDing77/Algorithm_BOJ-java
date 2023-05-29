import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int res = 0;
        if (A < 0) {
            int first = Math.abs(A) * C;
            int second = D;
            int third = B * E;
            res = first + second + third;
        } else {
            int diff = B - A;
            res = diff * E;
        }

        System.out.println(res);
    }
}