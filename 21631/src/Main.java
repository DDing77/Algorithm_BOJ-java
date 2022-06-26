import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a  = Long.parseLong(st.nextToken());
        b  = Long.parseLong(st.nextToken());

        long res;
        if( a >= b) res = b;
        else res = a + 1;

        System.out.println(res);
    }
}