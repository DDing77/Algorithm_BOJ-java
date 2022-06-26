import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t1, m1;
    static int t2, m2;
    static int diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());

        m1 += t1 * 60;
        m2 += t2 * 60;

        if (m1 > m2) m2 += 24 * 60;
        diff = m2 - m1;

        System.out.println(diff + " " + diff / 30);
    }
}