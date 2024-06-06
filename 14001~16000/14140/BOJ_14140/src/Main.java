import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final HashMap<Character, int[]> direction = new HashMap<>();
    private int N;
    private String dirStr;
    private int K;
    private int res;

    private void initDirectionMap() {

        direction.put('L', new int[]{0, -1});
        direction.put('R', new int[]{0, 1});
        direction.put('U', new int[]{-1, 0});
        direction.put('D', new int[]{1, 0});
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dirStr = st.nextToken();

        initDirectionMap();

        K = Integer.parseInt(br.readLine());

        Person a = new Person(0, 0);
        Person b = new Person(0, 0);
        for (int i = 0; i < N - 1; i++) {
            a.move(direction.get(dirStr.charAt(i)));

            if (i >= K) {
                b.move(direction.get(dirStr.charAt(i - K)));
            }
            if (i >= K - 1 && a.isNear(b)) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Person {

        int x;
        int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isNear(Person o) {
            if (Math.abs(this.x - o.x) <= 1 && Math.abs(this.y - o.y) <= 1) {
                return true;
            }
            return false;
        }

        public void move(int[] direction) {
            this.x += direction[0];
            this.y += direction[1];
        }
    }
}
