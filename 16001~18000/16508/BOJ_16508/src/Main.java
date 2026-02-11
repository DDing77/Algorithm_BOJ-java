import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String target;
    private int[] targetCntArr;
    private int N;
    private int[] priceArr;
    private String[] subjects;
    private int resMin = Integer.MAX_VALUE;

    private int[] count(int[] countArr, String str) {
        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i) - 'A']++;
        }
        return countArr;
    }

    private void solution() throws IOException {
        target = br.readLine();
        targetCntArr = new int[26];
        count(targetCntArr, target);

        N = Integer.parseInt(br.readLine());
        priceArr = new int[N];
        subjects = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            priceArr[i] = Integer.parseInt(st.nextToken());
            subjects[i] = st.nextToken();
        }

        for (int bit = 1; bit < (1 << N); bit++) {
            int[] tempCntArr = new int[26];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((bit & ( 1 << i)) != 0) {
                    sum += priceArr[i];
                    count(tempCntArr, subjects[i]);
                }
            }

            boolean flg = true;
            for (int i = 0; i < targetCntArr.length; i++) {
                if (targetCntArr[i] > tempCntArr[i]) {
                    flg = false;
                    break;
                }
            }

            if (flg) {
                resMin = Math.min(resMin, sum);
            }
        }

        if (resMin == Integer.MAX_VALUE) {
            resMin = -1;
        }
        System.out.println(resMin);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
