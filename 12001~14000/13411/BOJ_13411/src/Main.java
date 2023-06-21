import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Missile[] missiles;

    public static double calculate(Missile missile) {
        return Math.sqrt(Math.pow(missile.x, 2) + Math.pow(missile.y, 2)) / missile.speed;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        missiles = new Missile[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            missiles[i] = new Missile(i + 1, Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(missiles);

        for (int i = 0; i < N; i++) {
            sb.append(missiles[i].number).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Missile implements Comparable<Missile> {
        int number;
        int x;
        int y;
        int speed;
        double time;

        public Missile(int number, int x, int y, int speed) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.time = calculate(this);
        }

        @Override
        public int compareTo(Missile o) {
            if (this.time == o.time) {
                return this.number - o.number;
            }

            return this.time < o.time ? -1 : 1;
        }
    }
}
