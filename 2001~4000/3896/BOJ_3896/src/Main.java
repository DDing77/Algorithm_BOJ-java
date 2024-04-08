import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    boolean[] isNotPrimes;
    ArrayList<Integer> primeList;
    int[] primeArray;

    int T;
    int K;

    private void makePrimeTable() {

        isNotPrimes = new boolean[1_299_710];
        isNotPrimes[0] = true;
        isNotPrimes[1] = true;
        primeList = new ArrayList<>();
        for (int i = 2; i < isNotPrimes.length; i++) {
            if (!isNotPrimes[i]) {
                primeList.add(i);
                for (int j = i * 2; j < isNotPrimes.length; j += i) {
                    isNotPrimes[j] = true;
                }
            }
        }

        primeArray = new int[primeList.size()];
        int idx = 0;
        for (int prime : primeList) {
            primeArray[idx++] = prime;
        }
    }

    private void solution() throws IOException {

        makePrimeTable();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());

            if (!isNotPrimes[K]) {
                sb.append("0").append("\n");
                continue;
            }

            int left = -1;
            int right = primeArray.length - 1;
            while (left + 1 < right) {
                int mid = (left + right) >> 1;
                if (K < primeArray[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            if (right == 0) {
                sb.append("0");
            } else {
                sb.append(primeArray[right] - primeArray[right - 1]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
