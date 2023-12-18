import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    String origin;
    String trans;

    private boolean compare() {
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == trans.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        origin = br.readLine();
        trans = br.readLine();

        if (N % 2 == 0) {
            if (origin.equals(trans)) {
                System.out.println("Deletion succeeded");
            } else {
                System.out.println("Deletion failed");
            }
        } else {
            if (compare()) {
                System.out.println("Deletion succeeded");
            } else {
                System.out.println("Deletion failed");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
