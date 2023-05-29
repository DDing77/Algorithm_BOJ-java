import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int bit = 0;

    static void add(int x) {
        bit |= (1 << (x - 1));
    }

    static void remove(int x) {
        bit = bit & ~(1 << (x - 1));
    }

    static boolean check(int x) {
        if (((bit & (1 << x - 1)) != 0)) return true;
        else return false;
    }

    static void toggle(int x) {
        bit ^= (1 << (x - 1));
    }

    static void all() {
        bit |= (~0);
    }

    static void empty() {
        bit &= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int value;

            switch (op) {
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                case "add":
                    value = Integer.parseInt(st.nextToken());
                    add(value);
                    break;
                case "remove":
                    value = Integer.parseInt(st.nextToken());
                    remove(value);
                    break;
                case "check":
                    value = Integer.parseInt(st.nextToken());
                    if (check(value)) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "toggle":
                    value = Integer.parseInt(st.nextToken());
                    toggle(value);
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
