import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] A;
    private int cnt;
    private int answer1 = -1;
    private int answer2 = -1;
    private boolean found;

    private void quickSort(int left, int right) {
        if (found) {
            return;
        }

        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    private int partition(int left, int right) {
        int x = A[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (A[j] <= x) {
                i++;
                recordSwap(A[i], A[j]);
                swap(i, j);

                if (found) {
                    return i;
                }
            }
        }

        if (i + 1 != right) {
            recordSwap(A[i + 1], A[right]);
            swap(i + 1, right);

            if (found) {
                return i + 1;
            }
        }

        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void recordSwap(int a, int b) {
        cnt++;
        if (cnt == K) {
            answer1 = Math.min(a, b);
            answer2 = Math.max(a, b);
            found = true;
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);

        if (found) {
            System.out.println(answer1 + " " + answer2);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}