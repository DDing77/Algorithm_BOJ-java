import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int M, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        D = Integer.parseInt(br.readLine());

        if (M < 2) {
            System.out.println("Before");
        } else if (M == 2) {
            if (D < 18) {
                System.out.println("Before");
            } else if (D == 18) {
                System.out.println("Special");
            } else {
                System.out.println("After");
            }
        } else {
            System.out.println("After");
        }
    }
}