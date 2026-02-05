import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;
    private int D;
    private ArrayList<Integer> primeList = new ArrayList<>();
    private int res;

    private void setPrimeList(int a, int b) {
        boolean[] isPrime = new boolean[b + 1];
        for (int i = 2; i <= b; i++) {
            if (!isPrime[i]) {
                if (i >= a) {
                    primeList.add(i);
                }
                for (int j = i + i; j <= b; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        setPrimeList(A, B);

        for (int prime : primeList) {
            int temp = prime;
            while (temp > 0) {
                if (temp % 10 == D) {
                    res++;
                    break;
                }
                temp /= 10;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
