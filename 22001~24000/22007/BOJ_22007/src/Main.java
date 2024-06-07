import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long a;
    private long b;
    private int maxTwo;
    private int maxFive;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long i = a;
        long co = 1;
        while (i <= b) {
            long x = i;
            int two = 0;
            if (x % (co * 2) == 0) {
                co *= 2;
            }
            while (x % 2 == 0) {
                two++;
                x /= 2;
            }
            maxTwo = Math.max(maxTwo, two);
            i += co;
        }

        i = a;
        co = 1;
        while (i <= b) {
            long y = i;
            int five = 0;
            if (y % (co * 5) == 0) {
                co *= 5;
            }
            while (y % 5 == 0) {
                five++;
                y /= 5;
            }
            maxFive = Math.max(maxFive, five);
            i += co;
        }
        System.out.println(Math.min(maxTwo, maxFive));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
