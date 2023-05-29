import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());

        double cur = 1;
        int ans;
        while (true) {
            double temp = Math.ceil(cur / A);
            if (temp >= I) {
                ans = (int) temp;
                break;
            } else cur++;
        }

        System.out.println((int) cur);
    }
}
