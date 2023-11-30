import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    final int[] SUM_NUMBERS = {1, 2, 3};
    int N;
    int K;
    int order;
    String res;

    public void backTracking(int sum, ArrayList<Integer> selectNumbers) {
        if (sum == N) {
            if (++order == K) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < selectNumbers.size(); i++) {
                    sb.append(selectNumbers.get(i));
                    if (i != selectNumbers.size() - 1) {
                        sb.append("+");
                    }
                }
                res = sb.toString();
                return;
            }
        }

        for (int i = 0; i < SUM_NUMBERS.length; i++) {
            if (sum + SUM_NUMBERS[i] <= N) {
                selectNumbers.add(SUM_NUMBERS[i]);
                backTracking(sum + SUM_NUMBERS[i], selectNumbers);
                selectNumbers.remove(selectNumbers.size() - 1);
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = 0;
        backTracking(0, new ArrayList<>());
        if (res != null) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
