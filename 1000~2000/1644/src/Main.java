import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedMap;

public class Main {
    static int N;
    static int cnt;
    static boolean[] arr = new boolean[4000001];
    static ArrayList<Integer> prime;

    static void twoPointer(int start, int end, int target) {
        int L = start, R = 0;
        int sum = prime.get(0);
        while (R <= end) {
            if (sum == target) {
                cnt++;
                R++;
                if (R > end) break;
                sum += prime.get(R);
            } else if (sum > target) {
                sum -= prime.get(L);
                L++;
            } else {
                R++;
                if (R > end) break;
                sum += prime.get(R);
            }
        }
    }

    static void solution() {
        arr[0] = false;
        arr[1] = false;
        prime = new ArrayList<>();
        for (int i = 2; i*i <= 4000000; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= 4000000; j += i)
                    arr[j] = true;
            }
        }
        for(int i=1; i<=N;i++){
            if(!arr[i]) prime.add(i);
        }
        twoPointer(0, prime.size() - 1, N);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution();
    }
}
