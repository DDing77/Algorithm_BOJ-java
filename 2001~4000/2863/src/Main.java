import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> num;
    static int res;
    static double max;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        num = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        num.add(a);
        num.add(b);
        num.add(d);
        num.add(c);

        max = 0.0;
        res = -1;

        for (int i = 0; i <= 3; i++) {
            double val = (double) num.get(0) / num.get(1) + (double) num.get(3) / num.get(2);
            if (val > max) {
                max = val;
                res = i;
            }

            num.add(num.remove(0));
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}