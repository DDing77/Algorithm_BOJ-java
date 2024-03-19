import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] arr;
    int[] p;
    ArrayList<Integer> LIA;

    public int lowerBound(ArrayList<Integer> LIA, int start, int end, int target) {

        int L = start;
        int R = end;

        while (L < R) {
            int mid = (L + R) / 2;
            if (LIA.get(mid) >= target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return R;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        p = new int[N + 1];
        LIA = new ArrayList<>();
        LIA.add(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (LIA.get(LIA.size() - 1) < arr[i]) {
                LIA.add(arr[i]);
            } else {
                int lia_idx = lowerBound(LIA, 1, LIA.size() - 1, arr[i]);
                LIA.set(lia_idx, arr[i]);
            }
        }

        System.out.println(LIA.size() - 1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}


