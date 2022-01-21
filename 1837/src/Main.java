import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int MAX =1000000;
    static char[] P;
    static int K;
    static boolean[] arr;
    static List<Integer> primes = new ArrayList<>();

    static boolean checkIsBad(int x) {
        int r= 0;
        for(int i=0; i<P.length; i++) {
            r= (r * 10 + Integer.parseInt(String.valueOf(P[i])) % x);
        }
        if(r == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[MAX+1];
        for(int i=2; i<=MAX; i++) {
            if(!arr[i]) {
              primes.add(i);
              for(int j= i *2; j<= MAX; j += i) {
                  arr[j] = true;
              }
            }
        }

        for(int prime : primes) {
            if(prime >= K) {
                break;
            }
            if(checkIsBad(prime)) {
                System.out.println("BAD");
                return;
            }
        }
        System.out.println("GOOD");
    }
}
