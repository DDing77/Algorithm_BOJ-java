import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final String[] message = {
            "BNP",
            "TIMING",
            "SAMESAME"
    };
    private int N;
    private int[] prices;

    public int getBNP() {
        int remain = N;
        int cnt = 0;

        for (int i = 0; i < 14; i++) {
            cnt += remain / prices[i];
            remain %= prices[i];
        }

        return remain + cnt * prices[13];
    }

    public int getTIMING() {
        int remain = N;
        int cnt = 0;

        for (int i = 3; i < 14; i++) {
            if (prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1]) {
                remain += cnt * prices[i];
                cnt = 0;
            } else if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1]) {
                cnt += remain / prices[i];
                remain %= prices[i];
            }
        }

        return remain + cnt * prices[13];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        prices = new int[14];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int resA = getBNP();
        int resB = getTIMING();

        if (resA == resB) {
            System.out.println(message[2]);
        } else if (resA > resB) {
            System.out.println(message[0]);
        } else {
            System.out.println(message[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}