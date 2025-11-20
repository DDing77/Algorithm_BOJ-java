import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private boolean[] origin;
    private boolean[] target;

    private boolean isSame(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private int execSearch(boolean[] from, boolean[] to, int count) {
        for (int i = 1; i < N - 1; i++) {
            if (from[i - 1] != to[i - 1]) {
                for (int j = i - 1; j < i + 2; j++) {
                    from[j] = !from[j];
                }
                count++;
            }
        }

        if (from[N - 1] != to[N - 1]) {
            for (int i = N - 2; i < N; i++) {
                from[i] = !from[i];
            }
            count++;
        }
        if (isSame(from, to)) {
            return count;
        }
        return -1;
    }

    private boolean[] copy(boolean[] arr) {
        boolean[] copy = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        origin = new boolean[N];
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == '1') {
                origin[i] = true;
            }
        }

        target = new boolean[N];
        input = br.readLine();
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == '1') {
                target[i] = true;
            }
        }

        boolean[] first = copy(origin);
        int count = execSearch(first, target, 0);
        if (count != -1) {
            System.out.println(count);
            return;
        }

        boolean[] second = copy(origin);
        second[0] = !second[0];
        second[1] = !second[1];
        count = execSearch(second, target, 1);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
