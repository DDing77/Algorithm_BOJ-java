import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] divide;
    static boolean[] rowNumber;
    static ArrayList<Integer> primeList;
    static int cnt;
    static int score;

    static void getPrime() {
        rowNumber = new boolean[1_000_001];
        primeList = new ArrayList<>();
        for (int i = 2; i * i <= 1_000_000; i++) {
            if (rowNumber[i]) continue;
            for (int j = i * i; j <= 1_000_000; j += i) {
                rowNumber[j] = true;
            }
        }

        for(int i=2; i<=1_000_000; i++) {
            if(!rowNumber[i]) primeList.add(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        getPrime();
        N = Integer.parseInt(br.readLine());


        score = 1;
        cnt = 0;
        int[] usePrime = new int[1_000_001];
        divide = new int[N][primeList.size()];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            for (int j = 0; j < primeList.size(); j++) {
                while (cur % primeList.get(j) == 0) {
                    usePrime[primeList.get(j)]++;
                    divide[i][j]++;
                    cur /= primeList.get(j);
                }
            }
        }

        for (int i = 0; i < primeList.size(); i++) {
            int need = usePrime[primeList.get(i)] / N;
            for (int j = 0; j < N; j++) {
                if (divide[j][i] < need) cnt += need - divide[j][i];
            }
            score *= (int) Math.pow(primeList.get(i), need);
        }

        System.out.println(score + " " + cnt);
    }
}
