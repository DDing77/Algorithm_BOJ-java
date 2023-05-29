import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long S;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Long.parseLong(br.readLine());

        res = 0;
        long cur = 1;
        
        while (S - cur >= 0) {
            res++;
            S -= cur;
            cur++;
        }

        System.out.println(res);
    }
}

