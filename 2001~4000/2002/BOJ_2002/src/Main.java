import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    HashMap<String, Integer> inList = new HashMap<>();
    int[] outList;
    int N;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            inList.put(br.readLine(), i);
        }

        outList = new int[N];
        for (int i = 0; i < N; i++) {
            outList[i] = inList.get(br.readLine());
        }

        res = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (outList[i] > outList[j]) {
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
