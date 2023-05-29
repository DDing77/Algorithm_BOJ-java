import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static ArrayList<Integer> list;
    static int sum;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = 0;
        max = 0;
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        for (int i = 0; i < N; i++) list.add(list.get(i) + M);

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1) - 2 * R;
            sum += diff;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        System.out.println((max + 1) / 2);
    }
}
