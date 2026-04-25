import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private LinkedList<Integer> dq = new LinkedList<>();

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        int i = 1;
        int target = 0;
        while (dq.size() != 1) {
            long pow3 = (long) Math.pow(i, 3);
            target = (int) ((target + pow3 - 1) % dq.size());
            dq.remove(target);
            i++;
        }

        System.out.println(dq.peek());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
