import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int p1, s1, s2, p2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p1 = Integer.parseInt(st.nextToken());
        s1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s2 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int p = p1 + p2;
        int s = s1 + s2;

        if (p > s) System.out.println("Persepolis");
        else if (s > p) System.out.println("Esteghlal");
        else {
            if (p2 > s1) System.out.println("Persepolis");
            else if (s1 > p2) System.out.println("Esteghlal");
            else System.out.println("Penalty");
        }
    }
}