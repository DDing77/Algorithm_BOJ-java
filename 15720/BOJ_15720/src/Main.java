import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private int B, C, D;
    private Integer[] burgers, sides, beverages;
    private int total, res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int minLength = Math.min(B, Math.min(C, D));

        total = 0;
        burgers = new Integer[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            burgers[i] = Integer.parseInt(st.nextToken());
            total += burgers[i];
        }
        Arrays.sort(burgers, Collections.reverseOrder());

        sides = new Integer[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            sides[i] = Integer.parseInt(st.nextToken());
            total += sides[i];
        }
        Arrays.sort(sides, Collections.reverseOrder());

        beverages = new Integer[D];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            beverages[i] = Integer.parseInt(st.nextToken());
            total += beverages[i];
        }
        Arrays.sort(beverages, Collections.reverseOrder());

        res = 0;
        for (int i = 0; i < minLength; i++) {
            res += (burgers[i] + sides[i] + beverages[i]) * 0.9;
        }

        for (int i = minLength; i < B; i++) {
            res += burgers[i];
        }

        for (int i = minLength; i < C; i++) {
            res += sides[i];
        }

        for (int i = minLength; i < D; i++) {
            res += beverages[i];
        }

        sb.append(total).append('\n');
        sb.append(res);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
