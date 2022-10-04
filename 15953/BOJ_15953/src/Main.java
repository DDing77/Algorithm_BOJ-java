import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int T;
    static int a, b;
    static int[] c2017 = {500, 300, 200, 50, 30, 10};
    static int[] m2017 = {1, 2, 3, 4, 5, 6};
    static int[] c2018 = {512, 256, 128, 64, 32};
    static int[] m2018 = {1, 2, 4, 8, 16};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int money = 0;
            int temp = 0;

            if (a != 0) {
                for (int i = 0; i < 6; i++) {
                    if (temp + m2017[i] >= a) {
                        money += c2017[i];
                        break;
                    }
                    temp += m2017[i];
                }
            }

            temp = 0;

            if (b != 0) {
                for (int i = 0; i < 5; i++) {
                    if (temp + m2018[i] >= b) {
                        money += c2018[i];
                        break;
                    }
                    temp += m2018[i];
                }
            }
            System.out.println(money * 10000);
        }
    }
}