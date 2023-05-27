import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.toBinaryString(Integer.parseInt(br.readLine()));
        int cnt = 0;

        for (int i = 0; i < N.length(); i++) {
            if (N.charAt(i) == '1') {
                cnt++;
            }

            if (cnt > 1) {
                System.out.println("0");
                return;
            }
        }

        if (cnt == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
