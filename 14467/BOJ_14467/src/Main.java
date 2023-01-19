import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int res;
    static int number, where;
    static HashMap<Integer, Integer> cows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cows = new HashMap<>();
        res = 0;

        N = Integer.parseInt(br.readLine());


        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            number = Integer.parseInt(st.nextToken());
            where = Integer.parseInt(st.nextToken());

            if (!cows.containsKey(number)) {
                cows.put(number, where);
            } else {
                if (cows.get(number) != where) {
                    res++;
                    cows.put(number, where);
                }
            }
        }

        System.out.println(res);
    }
}
