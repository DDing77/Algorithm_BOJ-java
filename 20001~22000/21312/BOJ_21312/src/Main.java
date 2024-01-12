import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int[] beverage;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        res = 0;
        beverage = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beverage.length; i++) {
            beverage[i] = Integer.parseInt(st.nextToken());

            if (beverage[i] % 2 == 1) {
                res = Math.max(res, beverage[i]);
            }
        }

        for (int i = 0; i < beverage.length; i++) {
            for (int j = i + 1; j < beverage.length; j++) {
                int mul = beverage[i] * beverage[j];
                if (mul % 2 == 1) {
                    res = Math.max(res, mul);
                }
                for (int k = j + 1; k < beverage.length; k++) {
                    mul *= beverage[k];
                    if (mul % 2 == 1) {
                        res = Math.max(res, mul);
                    }
                }
            }
        }

        if (res == 0) {
            res = 1;
            for (int i = 0; i < beverage.length; i++) {
                res *= beverage[i];
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
