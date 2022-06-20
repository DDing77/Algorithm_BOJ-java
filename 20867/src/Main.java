import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m, s, g, l, r;
    static double a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int ls = m % g > 0 ? m / g + 1 : m / g;
        int rs = m % s > 0 ? m / s + 1 : m / s;

        int lWait = (int) (l / a);
        int rWait = (int) (r / b);

        if (ls < rs) {
            if (ls + lWait < rs + rWait) System.out.println("friskus");
            else System.out.println("latmask");
        } else {
            if (ls + lWait < rs + rWait) System.out.println("friskus");
            else System.out.println("latmask");
        }
    }
}