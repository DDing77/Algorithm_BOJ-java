import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int wc, hc, ws, hs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        wc = Integer.parseInt(st.nextToken());
        hc = Integer.parseInt(st.nextToken());
        ws = Integer.parseInt(st.nextToken());
        hs = Integer.parseInt(st.nextToken());

        if (wc - ws >= 2 && hc - hs >= 2) System.out.println(1);
        else System.out.println(0);
    }
}