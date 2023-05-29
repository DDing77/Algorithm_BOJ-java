import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " : ");

        int h1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());

        int t1 = h1 * 3600 + m1 * 60 + s1;

        st = new StringTokenizer(br.readLine(), " : ");
        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int t2 = h2 * 3600 + m2 * 60 + s2;

        if (t1 > t2) System.out.println(t2 - t1 + 3600 * 24);
        else System.out.println(t2 - t1);
    }
}