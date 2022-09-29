import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static String n;
    static int res;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 0; i < n.length(); i++) {
            if ('0' <= n.charAt(i) && n.charAt(i) <= '9') {
                res = res * b + ((int) n.charAt(i) - (int) '0');
            } else {
                res = res * b + ((int) n.charAt(i) - (int) 'A' + 10);
            }
        }

        System.out.println(res);
    }
}