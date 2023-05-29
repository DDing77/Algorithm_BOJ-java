import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;
    static boolean[] primes;
    static ArrayList<Integer> primeList;

    public static void getPrimes() {
        primes = new boolean[111];
        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i <= Math.sqrt(110); i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= 110; j += i) {
                    primes[j] = true;
                }
            }
        }

        primeList = new ArrayList<>();
        for (int i = 2; i <= 110; i++) {
            if (!primes[i]) {
                primeList.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        getPrimes();

        for (int i = 0; i < primeList.size() - 1; i++) {
            int temp = primeList.get(i) * primeList.get(i + 1);
            if (temp > N) {
                System.out.println(temp);
                return;
            }
        }
    }
}
