import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String N;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        int NtoInteger = Integer.parseInt(N);

        if (N.contains("7")) {
            if (NtoInteger % 7 == 0) {
                System.out.println(3);
            } else {
                System.out.println(2);
            }
        } else {
            if (NtoInteger % 7 == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
