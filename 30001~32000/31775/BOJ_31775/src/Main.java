import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private boolean lFlag;
    private boolean kFlag;
    private boolean pFlag;

    private void solution() throws IOException {
        for (int i = 0; i < 3; i++) {
            Character c = br.readLine().charAt(0);
            if (c == 'l') {
                lFlag = true;
            } else if (c == 'k') {
                kFlag = true;
            } else if (c == 'p') {
                pFlag = true;
            } else {
                break;
            }
        }

        if (lFlag && kFlag && pFlag) {
            System.out.println("GLOBAL");
        } else {
            System.out.println("PONIX");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
