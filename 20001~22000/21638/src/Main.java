import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t1, t2;
    static int v1, v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t1 = Integer.parseInt(st.nextToken());
        v1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        t2 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        if (t2 < 0 && v2 >= 10) {
            System.out.println("A storm warning for tomorrow! Be careful and stay home if possible!");
        } else if (t2 < t1) {
            System.out.println("MCHS warns! Low temperature is expected tomorrow.");
        } else if (v1 < v2) {
            System.out.println("MCHS warns! Strong wind is expected tomorrow.");
        } else {
            System.out.println("No message");
        }
    }
}