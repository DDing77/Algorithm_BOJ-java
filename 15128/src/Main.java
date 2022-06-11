import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long p1 = Integer.parseInt(st.nextToken());
        long q1 = Integer.parseInt(st.nextToken());
        long p2 = Integer.parseInt(st.nextToken());
        long q2 = Integer.parseInt(st.nextToken());

        boolean isRational = (p1 * p2 % (q1 * q2 * 2) == 0);

        if (!isRational) System.out.println(0);
        else System.out.println(1);

    }
}
