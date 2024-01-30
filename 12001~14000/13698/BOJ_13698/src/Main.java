import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    String input;
    int[] cups;

    private void swap(int a, int b) {
        int temp = cups[a];
        cups[a] = cups[b];
        cups[b] = temp;
    }

    private void solution() throws IOException {
        cups = new int[4];
        cups[0] = 1;
        cups[3] = 2;


        input = br.readLine();
        for (char c : input.toCharArray()) {
            int left = Type.valueOf(String.valueOf(c)).getLeft();
            int right = Type.valueOf(String.valueOf(c)).getRight();

            swap(left, right);
        }

        int smallIdx = 0;
        int bigIdx = 3;
        for (int i = 0; i < cups.length; i++) {
            if (cups[i] == 0) {
                continue;
            }
            if (cups[i] == 1) {
                smallIdx = i;
                continue;
            }
            if (cups[i] == 2) {
                bigIdx = i;
            }
        }

        sb.append(smallIdx+ 1).append("\n").append(bigIdx + 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    enum Type {
        A(0, 1),
        B(0, 2),
        C(0, 3),
        D(1, 2),
        E(1, 3),
        F(2, 3);

        final int left;
        final int right;

        Type(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
}
